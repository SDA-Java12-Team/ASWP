package cz.coffee.requests;

import cz.coffee.accessors.Access;

public class Controller {
    private String urlBank;
    private String client_id;
    private String state;
    private String redirect_uri;

    public boolean GET(){
        return false;
    }
    public boolean POST(){
        return false;
    }

    public Access PUT(){
        return Access.UNKNOWN;
    }



    public String httpsStringConstructor(){
        return "";
    }
}
