package cz.coffee.controllers;

public class TeamsController {

    private String subject;

    private int startDateTime;

    private int endDateTime;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(int startDateTime) {
        this.startDateTime = startDateTime;
    }

    public int getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(int endDateTime) {
        this.endDateTime = endDateTime;
    }



    public TeamsController(String subject, int startDateTime, int endDateTime) {
        this.subject = subject;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }



    public static void createMeeting() {
        System.out.println();
    }

    public static void deleteMeeting(){

    }
}
