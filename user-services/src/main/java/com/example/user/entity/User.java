package com.example.user.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Creator: Nguyen Ngoc Tri
 * Date: 6/26/2023
 * Time: 10:23 PM
 */
@Entity
@Table(
        name="user",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"username"})
)
public class User {

    @Id
    private String userId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String username;
    private LocalDate dob;
    private Integer gender;
    @Column(nullable = false, columnDefinition="int default 0")
    private Integer isDeleted;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private String createdBy;
    @Column(nullable = false)
    private LocalDateTime modifiedAt;
    @Column(nullable = false)
    private String modifiedBy;

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public User setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public LocalDate getDob() {
        return dob;
    }

    public User setDob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public User setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public User setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public User setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public User setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }
}
