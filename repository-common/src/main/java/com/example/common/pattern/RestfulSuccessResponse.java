package com.example.common.pattern;

import com.google.gson.JsonObject;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 4/22/19
 * Time: 4:47 PM
 */
public class RestfulSuccessResponse extends RestfulCommonResponse {

    public RestfulSuccessResponse() {
        this.code = CodeResponse.HttpStatusCode.OK.getCode();
        this.messages = CodeResponse.HttpStatusCode.OK.getMessage();
        this.data = null;
    }
}
