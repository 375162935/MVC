package com.yyn.service;

import com.yyn.bean.UserInfo;
import com.yyn.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨以诺
 * by 2020-04-04 14:11
 */
@Service("userService")
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<UserInfo> findAll() { return userInfoDao.findAll(); }

    @Override
    public UserInfo login(String username) {
        return userInfoDao.login(username);
    }

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoDao.addUserInfo(userInfo);
    }
}
