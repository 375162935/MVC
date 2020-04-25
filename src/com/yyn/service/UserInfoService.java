package com.yyn.service;

import com.yyn.bean.UserInfo;

import java.util.List;

/**
 * @author 杨以诺
 * by 2020-04-04 14:11
 */
public interface UserInfoService {
    List<UserInfo> findAll();

    UserInfo login(String username);

    int addUserInfo(UserInfo userInfo);

}
