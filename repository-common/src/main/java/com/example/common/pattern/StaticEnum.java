package com.example.common.pattern;

import com.example.common.exception.CommonException;


/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Tri
 * Date: 30/12/2020
 * Time: 10:54 AM
 */
public class StaticEnum {

    public enum GenderEnum {
        FEMALE(0),
        MALE(1),
        ;
        private Integer code;

        GenderEnum(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public static GenderEnum safeValueOf(Integer code) {
            for (GenderEnum item : values()) {
                if (item.getCode().equals(code)) {
                    return item;
                }
            }
            throw new CommonException.UnknownValuesException("Unknown gender enum with values " + code);
        }
    }

    public enum IsDeletedEnum {
        YES(1, "yes"),
        NO(0, "no"),
        ;
        private Integer code;
        private String description;

        IsDeletedEnum(Integer code, String description) {
            this.code = code;
            this.description = description;
        }

        public Integer getCode() {
            return code;
        }

        public static IsDeletedEnum safeValueOf(Integer code) {
            for (IsDeletedEnum item :
                    values()) {
                if (item.getCode().equals(code))
                    return item;
            }
            throw new CommonException.UnknownValuesException("Not found enum with code " + code);
        }
    }

}
