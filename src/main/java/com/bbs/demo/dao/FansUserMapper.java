package com.bbs.demo.dao;

import com.bbs.demo.pojo.FansUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Program: demo
 * @Description:粉丝&用户数据访问接口
 * @Author:wzh
 * @Date:2020/9/17
 * @Version 1.0
 */
@Mapper
@Repository
public interface FansUserMapper {

    //查询当前用户的粉丝
    public List<String> queryFansList(FansUser fansUser) throws RuntimeException;

    //查询当前用户的粉丝量
    public Integer queryFansNum(Integer uid) throws RuntimeException;

    //查询当前用户的关注
    public List<Map> queryUserConcern(FansUser fansUser) throws RuntimeException;

    //查询当前用户的关注数量
    public Integer queryConcernNum(Integer uid) throws RuntimeException;

    //查询当前用户的文章被点赞情况
    public List<Map> queryLikeInfo(FansUser fansUser) throws RuntimeException;


}