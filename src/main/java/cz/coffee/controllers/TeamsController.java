package cz.coffee.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TeamsController {

    private String meetingID;

    private String subject;

    private ZonedDateTime startDateTime;

    private ZonedDateTime endDateTime;

    private LocalTime duration;

    private String[] participants;

    private int participantsCount;

    private Random random = new Random();


    public TeamsController(String meetingID) {
        //
        // this class will be called like:
        // TeamsController teamsController = new TeamsController("ds654sdf456dsf5ds4f6");
        //
        // TODO make a methods to fill the duration
        this.meetingID = meetingID;
        this.subject = this.createSubject();
        this.participants = this.createParticipants(10);
        this.startDateTime = this.createStartDateTime();
        this.endDateTime = this.createEndDateTime();
        this.participantsCount = this.getParticipantsCount();
    }

    public String getSubject() {
        return this.subject;
    }

    public String[] getParticipants() {
        return this.participants;
    }

    public int getParticipantsCount() {
        return this.participants.length;
    }

    public void getDuration() {
        // TODO finish this method, make a correct return format
        // I have no idea what format we need here.

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
        ZonedDateTime now = ZonedDateTime.parse(formatter.format(ZonedDateTime.now()));

        Duration duration = Duration.between(this.startDateTime, now.plusMinutes(50));
        long s = duration.getSeconds();

        System.out.printf("%d:%02d:%02d", s/3600, (s%3600)/60, (s%60));
    }

    public ZonedDateTime getStartDateTime() {
        return this.startDateTime;
    }

    public ZonedDateTime getEndDateTime() {
        return this.endDateTime;
    }


    private String[] createParticipants(int number) {

        if (number < 1) return null;

        String[] participants = new String[number];

        for (int i = 0; i < participants.length; i++) {

            int responseCode;
            InputStream inputStream;
            try {
                URL url = URI.create("https://api.namefake.com/").toURL();
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                inputStream = conn.getInputStream();

                responseCode = conn.getResponseCode();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();
            String line;

            if (responseCode != 200) {
                return null;
            }

            try {
                br = new BufferedReader(new InputStreamReader(inputStream));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            JsonObject jobj = new Gson().fromJson(sb.toString(), JsonObject.class);
            participants[i] = jobj.get("name").toString();
        }
        return participants;
    }

    private ZonedDateTime createEndDateTime() {
        int hours = this.random.nextInt(24);
        int minutes = this.random.nextInt(60);

        return this.startDateTime.plusHours(hours).plusMinutes(minutes);
    }

    private ZonedDateTime createStartDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");

        return ZonedDateTime.parse(formatter.format(ZonedDateTime.now()));
    }

    private String createSubject() {

        // random integer between 2 - 6
        int wordsLength = this.random.nextInt(5) + 2;
        // random integer between 2 - 4
        int numberOfWords = this.random.nextInt((4 - 2) + 1) + 2;
        String result = "";

        for (int i = 0; i < numberOfWords; i++) {
            String word = "";
            for (int j = 0; j < wordsLength; j++) {
                char ch = (char) (this.random.nextInt(26) + 'a');

                if (j == 0) {
                    ch = Character.toUpperCase(ch);
                }

                word = word.concat(String.valueOf(ch));
            }
            result = result.concat(word);

            if (i != numberOfWords - 1) {
                result = result.concat(" ");
            }
        }

        return result;
    }
}
