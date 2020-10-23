package com.bbs.demo.dao;

import com.bbs.demo.pojo.UserCollect;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Program: demo
 * @Description:用户&我的点赞、收藏数据访问接口
 * @Author:wzh
 * @Date:2020/9/17
 * @Version 1.0
 */
public interface UserCollectMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserCollect queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserCollect> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userCollect 实例对象
     * @return 对象列表
     */
    List<UserCollect> queryAll(UserCollect userCollect);

    /**
     * 新增数据
     *
     * @param userCollect 实例对象
     * @return 影响行数
     */
    int insert(UserCollect userCollect);

    /**
     * 修改数据
     *
     * @param userCollect 实例对象
     * @return 影响行数
     */
    int update(UserCollect userCollect);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}