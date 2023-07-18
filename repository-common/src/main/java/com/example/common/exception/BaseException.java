package com.example.common.exception;

/**
 * Creator: Nguyen Ngoc Chau
 * Date: 11/30/20
 * Time: 10:25 AM
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -128216908108589678L;

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
