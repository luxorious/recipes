package com.recipes.schedule;

import com.recipes.entity.Recipe;
import com.recipes.entity.User;
import com.recipes.service.interfaces.MailSenderService;
import com.recipes.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduledReportGenerationImpl implements ScheduledReportGeneration {

    private final UserService userService;
    private final MailSenderService mailSender;

    private Map<String, String> report;

    @Value(value = "${schedule.mailMessage}")
    private String mailMessage;

    @Override
    @Scheduled(cron = "0 0 0 1 * ?")//midnight every month
    public void generation() {
        report = new ConcurrentHashMap<>();
        Thread thread = new Thread(() -> {
            List<User> users = userService.getAllUsers();
            for (User user : users) {
                String mail = user.getEMail();
                String textMessage = createMessage(user.getRecipes());
                report.put(mail, textMessage);
            }
        });
        thread.start();
    }

    @Override
    @Scheduled(cron = "0 0 12 1 * ?")//midday every month
    public void send() {
        Thread sendReportThread = new Thread(() -> {
            if (report != null) {
                for (Map.Entry<String, String> reportData : report.entrySet()) {
                    mailSender.send(reportData.getKey(), reportData.getValue());
                }
            }
        });
        sendReportThread.start();
    }

    private synchronized String createMessage(List<Recipe> recipes) {
        String message = "";
        for (Recipe recipe : recipes) {
            message = mailMessage + "\n" +
                    "Recipe name - " + recipe.getName() + "\n" +
                    "Rating - " + recipe.getRating();
        }
        return message;
    }
}
