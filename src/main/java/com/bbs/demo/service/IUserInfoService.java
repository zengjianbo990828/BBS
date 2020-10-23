package com.bbs.demo.service;

import com.bbs.demo.pojo.UserInfo;

import java.util.List;


public interface IUserInfoService {
    //添加用户
    void addUserInfo(UserInfo userInfo);

    //修改用户
    Integer updateUserInfo (UserInfo userInfo);

    //删除用户
    void deleteUserInfo(Integer userid);

    //查找所有用户
    List<UserInfo> queryUserInfoList();

    //查询单个用户
    UserInfo queryUserInfo(UserInfo userInfo);

}
