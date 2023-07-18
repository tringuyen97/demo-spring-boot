package com.example.user.controller.request;

import java.time.LocalDate;

/**
 * Creator: Nguyen Ngoc Tri
 * Date: 6/27/2023
 * Time: 10:04 PM
 */
public class UpdateUserRequest {

    private String userId;
    private String name;
    private LocalDate dob;
    private Integer gender;

    public String getUserId() {
        return userId;
    }

    public UpdateUserRequest setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public UpdateUserRequest setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDob() {
        return dob;
    }

    public UpdateUserRequest setDob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UpdateUserRequest setGender(Integer gender) {
        this.gender = gender;
        return this;
    }
}
