package com.example.common.pattern;

import com.google.gson.JsonObject;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 4/22/19
 * Time: 4:39 PM
 */
public class RestfulFailureResponse extends RestfulCommonResponse {

    public RestfulFailureResponse() {
        this.code = CodeResponse.HttpStatusCode.BAD_REQUEST.getCode();
        this.messages = CodeResponse.HttpStatusCode.BAD_REQUEST.getMessage();
        this.data = null;
    }


}
