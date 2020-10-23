package com.bbs.demo.dao;

import com.bbs.demo.pojo.FansUser;
import com.bbs.demo.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Program: demo
 * @Description:用户信息数据访问接口
 * @Author:hjm
 * @Date:2020/9/17
 * @Version 1.0
 */

@Mapper
@Repository
public interface UserInfoMapper {

    //添加用户
    void addUserInfo(UserInfo userInfo);

    //修改用户
    Integer updateUserInfo(UserInfo userInfo);

    //删除用户
    void deleteUserInfo(Integer userid);

    //查找所有用户
    List<UserInfo> queryUserInfoList();

    //查询单个用户
    UserInfo queryUserInfo(UserInfo userInfo);

}
