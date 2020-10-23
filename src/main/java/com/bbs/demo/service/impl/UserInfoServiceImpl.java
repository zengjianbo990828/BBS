package com.bbs.demo.service.impl;

import com.bbs.demo.dao.UserInfoMapper;
import com.bbs.demo.pojo.UserInfo;
import com.bbs.demo.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserInfoServiceImpl implements IUserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public void addUserInfo(UserInfo userInfo) {
        this.userInfoMapper.addUserInfo(userInfo);
    }

    @Override
    public Integer updateUserInfo(UserInfo userInfo) {
      return   this.userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    public void deleteUserInfo(Integer userid) {
        this.userInfoMapper.deleteUserInfo(userid);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserInfo> queryUserInfoList() {
        return this.userInfoMapper.queryUserInfoList();
    }

    @Override
    public UserInfo queryUserInfo(UserInfo userInfo) {
        return this.userInfoMapper.queryUserInfo(userInfo);
    }


}
