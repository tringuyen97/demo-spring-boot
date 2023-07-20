package com.example.user.services.impl;

import com.example.common.exception.CommonException;
import com.example.common.pattern.RestfulFailureResponse;
import com.example.common.pattern.RestfulSuccessResponse;
import com.example.common.pattern.StaticEnum;
import com.example.common.util.DateTimes;
import com.example.common.util.Generator;
import com.example.common.util.JsonConverter;
import com.example.common.util.LogAdapter;
import com.example.common.pattern.RestfulCommonResponse;
import com.example.user.controller.request.CreateUserRequest;
import com.example.user.controller.request.UpdateUserRequest;
import com.example.user.entity.User;
import com.example.user.repository.IUserRepo;
import com.example.user.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Creator: Nguyen Ngoc Tri
 * Date: 6/27/2023
 * Time: 10:20 PM
 */
@Service
public class UserServicesImpl implements IUserServices {

    private final LogAdapter LOGGER = LogAdapter.newInstance(this.getClass());

    private final IUserRepo userRepo;

    @Autowired
    public UserServicesImpl(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public RestfulCommonResponse getUserDetailByUserId(String userId) {
        LOGGER.info("Start get user detail by user id {}", userId);

        LOGGER.info("Done get user detail by user id {}", userId);
        return new RestfulSuccessResponse().setData(userRepo.getUserByUserId(userId));
    }

    @Override
    public RestfulCommonResponse createUser(CreateUserRequest request) {
        try {
            LOGGER.info("Start create user with request: {}", JsonConverter.toJson(request));
            User user = userRepo.getUserByUsername(request.getUsername());
            if (user != null)
                throw new CommonException.DuplicationException("Username already exists");
            userRepo.save(new User()
                    .setUserId(Generator.generateUserId())
                    .setName(request.getName())
                    .setUsername(request.getUsername())
                    .setDob(request.getDob())
                    .setGender(StaticEnum.GenderEnum.safeValueOf(request.getGender()).getCode())
                    .setIsDeleted(StaticEnum.IsDeletedEnum.NO.getCode())
                    .setCreatedAt(DateTimes.getCurrentLocalDateTime())
                    .setCreatedBy("system")
                    .setModifiedAt(DateTimes.getCurrentLocalDateTime())
                    .setModifiedBy("system")
            );
            LOGGER.info("Done create user with request: {}", request);
            return new RestfulSuccessResponse().setData(request);
        } catch (CommonException.DuplicationException e) {
            LOGGER.warn(e.getMessage());
            return new RestfulFailureResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return new RestfulFailureResponse();
        }
    }

    @Override
    public RestfulCommonResponse updateUser(UpdateUserRequest request) {
        LOGGER.info("Start update user with request: {}", request);

        LOGGER.info("Done update user with request: {}", request);
        return new RestfulSuccessResponse();
    }

    @Override
    public RestfulCommonResponse deleteUser(String userId) {
        LOGGER.info("Start delete user: {}", userId);

        LOGGER.info("Done delete user: {}", userId);
        return new RestfulSuccessResponse();
    }
}
