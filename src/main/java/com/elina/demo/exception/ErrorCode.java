package com.elina.demo.exception;

public enum ErrorCode {
    SOME_ERROR(1, "REASON ...");

    private int code;
    private String reason;

    ErrorCode(int i, String s) {
        code = i;
        reason = s;
    }

    public String getMessage() {
        return String.format("[CODE]: %d, [MESSAGE]: %s", code, reason);
    }
}