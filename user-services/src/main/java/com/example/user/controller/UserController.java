package com.example.user.controller;

import com.example.common.util.LogAdapter;
import com.example.common.pattern.RestfulCommonResponse;
import com.example.user.controller.request.CreateUserRequest;
import com.example.user.controller.request.UpdateUserRequest;
import com.example.user.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Creator: Nguyen Ngoc Tri
 * Date: 6/26/2023
 * Time: 10:19 PM
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final LogAdapter LOGGER = LogAdapter.newInstance(this.getClass());

    private IUserServices userServices;

    @Autowired
    public UserController(IUserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public RestfulCommonResponse getUserDetailByUserId(@RequestParam(value = "userId", defaultValue = "default") String userId) {
        return userServices.getUserDetailByUserId(userId);
    }

    @PostMapping
    public RestfulCommonResponse createUser(@RequestBody CreateUserRequest request) {
        return userServices.createUser(request);
    }

    @PutMapping
    public RestfulCommonResponse updateUser(@RequestBody UpdateUserRequest request) {
        return userServices.updateUser(request);
    }

    @DeleteMapping(path = "{userId}")
    public RestfulCommonResponse deleteUser(@PathVariable("userId") String userId) {
        return userServices.deleteUser(userId);
    }

}
