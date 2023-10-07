package com.loevc.celestia.common.util;

public enum ResponseCode {
    SUCCESS(0, "Success"),
    Fail(1, "fail"),
    ;

    private final int code;
    private final String msg;


    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
