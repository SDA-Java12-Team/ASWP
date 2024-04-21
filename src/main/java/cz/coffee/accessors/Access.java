package cz.coffee.accessors;

public enum Access {

    APPROVED(0x0),
    CANCELED(0x1),
    UNKNOWN(0x02),
    LIMITED(0x03);


    private final byte code;

    Access(int code) {
        this.code = (byte) code;
    }
    public byte getCode() {
        return code;
    }

}
