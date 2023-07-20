package com.example.user.repository;

import com.example.user.entity.User;

/**
 * Creator: Nguyen Ngoc Tri
 * Date: 7/8/2023
 * Time: 6:58 PM
 */
public class UserRepoImpl implements IUserRepo extends SimpleJpaRepositor {
    @Override
    public User getUserByUserId(String userId) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }
}
