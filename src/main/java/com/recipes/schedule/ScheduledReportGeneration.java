package com.recipes.schedule;

public interface ScheduledReportGeneration {

    /**
     * Scheduled method for generating reports
     * Method use another Thread and save report in ConcurrentHashMap
     * Scheduled is midnight every month
     */
    void generateReports();

    /**
     * Scheduled method for sending reports (using another thread)
     * Send report retrieves data (mail and message text) from Map and
     * sends them at midday on the 1st day of each month.
     */
    void sendReports();
}
