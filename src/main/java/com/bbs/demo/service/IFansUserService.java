package com.bbs.demo.service;

import com.bbs.demo.pojo.FansUser;

import java.util.List;
import java.util.Map;

/**
 * @author: 曾建波
 * @date: 2020-09-28
 * @description: 我的粉丝模块业务层
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bbs.demo.service
 */
public interface IFansUserService {
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
