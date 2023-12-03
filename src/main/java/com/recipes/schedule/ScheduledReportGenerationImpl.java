package com.recipes.schedule;

import com.recipes.entity.Recipe;
import com.recipes.entity.User;
import com.recipes.service.crud.interfaces.UserService;
import com.recipes.service.mailsender.MailSenderService;
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
public class ScheduledReportGenerationImpl {

    private final UserService userService;
    private final MailSenderService mailSender;

    private Map<String, String> report;

    @Value(value = "${schedule.mailMessage}")
    private String mailMessage;

    /**
     * Scheduled method for generating reports
     * Method use another Thread and save report in ConcurrentHashMap
     * Scheduled is midnight every month
     */
    @Scheduled(cron = "0 0 0 1 * ?")//midnight every month
    public void generateReports() {
        report = new ConcurrentHashMap<>();
        Thread thread = new Thread(() -> {
            List<User> users = userService.findAllUserEntity();
            for (User user : users) {
                String mail = user.getEMail();
                String textMessage = createMessage(user.getRecipes());
                report.put(mail, textMessage);
            }
        });
        thread.start();
    }

    /**
     * Scheduled method for sending reports (using another thread)
     * Sends report retrieves data (mail and message text) from Map and
     * sends them at midday on the 1st day of each month.
     */
    @Scheduled(cron = "0 0 12 1 * ?")//midday every month
    public void sendReports() {
        Thread sendReportThread = new Thread(() -> {
            if (report != null) {
                for (Map.Entry<String, String> reportData : report.entrySet()) {
                    mailSender.send(reportData.getKey(), reportData.getValue());
                }
            }
        });
        sendReportThread.start();
    }

    /**
     * Create a message text based on a list of recipes.
     *
     * @param recipes List of recipes from which the notification is generated
     * @return Generated message from name and rating from a recipe
     */
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
