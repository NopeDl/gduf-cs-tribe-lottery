package com.bigliang.draw.vo;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/22 19:32
 */

public class Message {

    private int code;
    private String message;

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
