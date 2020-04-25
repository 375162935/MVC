package com.yyn.dao;

import com.yyn.bean.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 杨以诺
 * by 2020-04-04 14:07
 */
@Repository
public interface UserInfoDao {
    List<UserInfo> findAll();

    UserInfo login(String username);

    int addUserInfo(UserInfo userInfo);
}
