package com.example.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Tri
 * Date: 25/09/2020
 * Time: 5:03 PM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {
    int value();
    boolean isParent() default false;
}
