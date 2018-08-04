package com.iem.safety.iembackend.utils;

import java.util.Map;

/**
 * 返回信息pojo
 *
 * @author MengQi 2018-06-15 17:23
 */
public class Message {
    private Map<String, Object> result;
    private String msg = "SUCCESS";
    private int code;

    public Message() {
    }

    public Message(Map<String, Object> result, String msg, int code) {
        this.result = result;
        this.msg = msg;
        this.code = code;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
