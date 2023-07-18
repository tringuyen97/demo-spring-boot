package com.example.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 4/23/19
 * Time: 2:06 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface CanNullOrEmpty {
}
