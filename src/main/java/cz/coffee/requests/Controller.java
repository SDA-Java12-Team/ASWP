package cz.coffee.requests;

import cz.coffee.accessors.Access;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Controller {
    private String urlBank;
    private String client_id;
    private String state;
    private String redirect_uri;
    private String clientSecret;
    private String apiKey;

    public Access GET(){
        return Access.UNKNOWN;
    }
    public Access POST(){
        return Access.UNKNOWN;
    }

    public Access PUT(){
        return Access.UNKNOWN;
    }

    public Access UPDATE(){
        return Access.UNKNOWN;
    }
    public Access DELETE(){
        return Access.UNKNOWN;
    }
    public Access PATCH(){
        return Access.UNKNOWN;
    }
    public Access OPTION(){
        return Access.UNKNOWN;
    }
    public Access HEAD(){
        return Access.UNKNOWN;
    }

    public static String getResponse(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URI uri = new URI(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }

    public String httpsStringConstructor(){
        //https://ib.airbank.cz/?client_id=MYID&response_type=code&state=ehshvnajgtf34
        return "";
    }
}
