package cz.coffee.controllers;

import java.time.LocalDateTime;

public class TeamsController {

    private String subject;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    public TeamsController(String subject, LocalDateTime startDateTime) {
        this.subject = subject;
        this.startDateTime = startDateTime;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public static void createMeeting() {
        System.out.println();
    }

    public static void deleteMeeting(){

    }
}
