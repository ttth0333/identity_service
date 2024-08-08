package com.trint.identity_service.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Exception"),
    INVALID_KEY(1005, "Invalid message key"), // sai code
    USER_EXISTED(1002, "Username already exists"),
    USERNAME_INVALID(1003, "Username is invalid, username must be around 5-20 characters"),
    PASSWORD_INVALID(1004, "Password is invalid, Password must be at least 8 characters");

    ErrorCode(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    private int errorCode;
    private String message;

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }


}
