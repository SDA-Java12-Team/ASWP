package cz.coffee;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        // CoffeeRequired...
        // Project Begin

        System.out.println(getResponse("https://www.seznam.cz"));

    }

    public static String getResponse(String urlToRead) throws Exception {
        URI uri = new URI(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
        conn.setRequestMethod("GET");

        String contentType = conn.getContentType();

        if (contentType != null && contentType.startsWith("text")) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder result = new StringBuilder();
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
                return result.toString();
            }
        } else {
            try (InputStream inputStream = conn.getInputStream()) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                StringBuilder result = new StringBuilder();
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    result.append(new String(buffer, 0, bytesRead, StandardCharsets.ISO_8859_1));
                }
                return result.toString();
            }
        }
    }
}