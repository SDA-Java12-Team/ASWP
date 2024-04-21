package cz.coffee.accessors;

public enum HTTPMethods {
    GET(1),
    POST(2),
    PUT(3),
    UPDATE(4),
    DELETE(5),
    PATCH(6),
    OPTION(7),
    HEAD(8);

    private final int code;

    HTTPMethods(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
