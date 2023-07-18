package com.example.user.services;

import com.example.common.pattern.RestfulCommonResponse;
import com.example.user.controller.request.CreateUserRequest;
import com.example.user.controller.request.UpdateUserRequest;

/**
 * Creator: Nguyen Ngoc Tri
 * Date: 6/27/2023
 * Time: 10:17 PM
 */
public interface IUserServices {

    RestfulCommonResponse getUserDetailByUserId(String userId);

    RestfulCommonResponse createUser(CreateUserRequest request);

    RestfulCommonResponse updateUser(UpdateUserRequest request);

    RestfulCommonResponse deleteUser(String userId);

}
