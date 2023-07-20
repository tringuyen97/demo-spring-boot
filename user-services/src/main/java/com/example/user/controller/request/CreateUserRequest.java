package com.example.user.controller.request;

import java.time.LocalDate;

/**
 * Creator: Nguyen Ngoc Tri
 * Date: 6/27/2023
 * Time: 10:04 PM
 */
public class CreateUserRequest {

    private String name;
    private String username;
    private LocalDate dob;
    private Integer gender;

    public String getName() {
        return name;
    }

    public CreateUserRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CreateUserRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public LocalDate getDob() {
        return dob;
    }

    public CreateUserRequest setDob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public CreateUserRequest setGender(Integer gender) {
        this.gender = gender;
        return this;
    }
}
