package com.example.user.service;

import com.example.user.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    public String addNewUser(UserInfo userInfo);

    List<UserInfo> getAllUserDetails();
}
