package com.shen.cloud.util;


public class ZmException extends RuntimeException {
    private String code;

    public ZmException(ZmCode zmCode) {
        this(zmCode.getCode(), zmCode.getDesc());
    }

    public ZmException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ZmException(ZmResult result){
        super(result.getRespDesc());
        this.code = result.getRespCode();
    }

    public ZmException(String code, String message, Object... args) {
        super(String.format(message, args));
        this.code = code;
    }

    public ZmException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
