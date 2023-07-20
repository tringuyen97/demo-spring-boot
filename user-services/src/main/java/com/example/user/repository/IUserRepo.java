package com.example.user.repository;

import com.example.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Creator: Nguyen Ngoc Tri
 * Date: 6/27/2023
 * Time: 11:00 PM
 */
public interface IUserRepo extends JpaRepository<User, Long> {

    User getUserByUserId(String userId);

    User getUserByUsername(String username);
}
