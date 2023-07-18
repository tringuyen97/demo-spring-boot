package com.example.common.pattern;

import com.google.gson.Gson;

/**
 * Creator: Nguyen Ngoc Tri
 * Date: 6/26/2023
 * Time: 10:19 PM
 */
public class RestfulCommonResponse {

    protected String code;
    protected Object data;
    protected String messages;

    public String getCode() {
        return code;
    }

    public RestfulCommonResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RestfulCommonResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public String getMessages() {
        return messages;
    }

    public RestfulCommonResponse setMessages(String messages) {
        this.messages = messages;
        return this;
    }

    public RestfulCommonResponse setResponse(CodeResponse.HttpStatusCode code) {
        this.code = String.valueOf(code.getCode());
        this.messages = code.getMessage();
        return this;
    }

    public RestfulCommonResponse setResponse(CodeResponse.ServerErrorCode code) {
        this.code = String.valueOf(code.getCode());
        this.messages = code.getMessage();
        return this;
    }

    public RestfulCommonResponse setResponse(CodeResponse.ClientErrorCode code) {
        this.code = String.valueOf(code.getCode());
        this.messages = code.getMessage();
        return this;
    }

    public RestfulCommonResponse setResponse(CodeResponse.SuccessCode code) {
        this.code = String.valueOf(code.getCode());
        this.messages = code.getMessage();
        return this;
    }

    public static class Builder {
        public static String response(RestfulCommonResponse response) {
            return new Gson().toJson(response);
        }
    }
}
