package com.recipes.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Slf4j
@Component
public class DailyPDFPurge {

    @Value("${autoDeleting.pathSavedPDf}")
    private String pathSavedPDf;

    /**
     * Method to delete all files within a specified folder.
     * Scheduled to run daily at midnight.
     */
    @Scheduled(cron = "0 0 0 * * *")//every day at midnight
    private void deleteFiles() {
        Path folderPath = Paths.get(pathSavedPDf);

        try (Stream<Path> paths = Files.list(folderPath)) {
            paths.forEach(path -> {
                try {
                    Files.delete(path);
                    log.info("Folder was cleared");
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage());
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
