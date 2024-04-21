package cz.coffee.requests;

import cz.coffee.accessors.Access;

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

    public String httpsStringConstructor(){
        //https://ib.airbank.cz/?client_id=MYID&response_type=code&state=ehshvnajgtf34
        return "";
    }
}
