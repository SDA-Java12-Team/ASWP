package cz.coffee.controllers;

//import com.google.gson.Gson;
//import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
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

    Random random = new Random();



    public TeamsController(String meetingID) {
        //
        // this class will be called like:
        // TeamController teamController = new TeamController("ds654sdf456dsf5ds4f6");
        //
        // TODO fill the rest fields from methods below (subject, startDateTime, endDateTime, participants)
        // TODO make a methods to fill the duration and participantsCount fields
            this.meetingID = meetingID;
            this.subject = createSubject();
    }
    public String getSubject() {
        return subject;
    }

//    private String[] createParticipants(int number) {
//
//        if (number < 1) return null;
//
//        String[] participants = new String[number];
//
//        for (int i = 0; i < participants.length; i++) {
//
//            int responseCode;
//            InputStream inputStream;
//            try {
//                URL url = URI.create("https://api.namefake.com/").toURL();
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                inputStream = conn.getInputStream();
//
//                responseCode = conn.getResponseCode();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            BufferedReader br = null;
//            StringBuilder sb = new StringBuilder();
//            String line;
//
//            if (responseCode != 200) {
//                return null;
//            }
//
//            try {
//                br = new BufferedReader(new InputStreamReader(inputStream));
//                while ((line = br.readLine()) != null) {
//                    sb.append(line);
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            } finally {
//                if (br != null) {
//                    try {
//                        br.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            JsonObject jobj = new Gson().fromJson(sb.toString(), JsonObject.class);
//            participants[i] = jobj.get("name").toString();
//        }
//        return participants;
//    }

    private ZonedDateTime createEndDateTime() {
        int hours = this.random.nextInt(24);
        int minutes = this.random.nextInt(60);

        return startDateTime.minusHours(hours).minusMinutes(minutes);
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
                char ch = (char) (random.nextInt(26) + 'a');

                if (j == 0) {
                    ch = Character.toUpperCase(ch);
                }

                word = word.concat(String.valueOf(ch));
            }
            result = result.concat(word + " ");
        }

        return result.trim();
    }
}
