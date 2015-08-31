package com.superc.commons.bean;

/**
 * Created by chao on 15/8/31.
 */
public class ResponseBeanTest {
    private Integer code;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
