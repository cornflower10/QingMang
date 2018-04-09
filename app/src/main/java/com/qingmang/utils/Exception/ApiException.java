package com.qingmang.utils.Exception;

/**
 * Created by xiejingbao on 2018/3/20.
 */

public class ApiException extends Exception {
    private int code;
    private String displayMessage;

    public ApiException(int code, String displayMessage) {
        super(displayMessage);
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public ApiException(String displayMessage) {
        super(displayMessage);
        this.displayMessage = displayMessage;
    }

    public ApiException(int code, String message, String displayMessage) {
        super(message);
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }


}
