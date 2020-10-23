package com.bbs.demo.dao;

import com.bbs.demo.pojo.RoleUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Program: demo
 * @Description:角色&用户数据访问接口
 * @Author:wzh
 * @Date:2020/9/17
 * @Version 1.0
 */
public interface RoleUserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param roleid 主键
     * @return 实例对象
     */
    RoleUser queryById(Integer roleid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<RoleUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param roleUser 实例对象
     * @return 对象列表
     */
    List<RoleUser> queryAll(RoleUser roleUser);

    /**
     * 新增数据
     *
     * @param roleUser 实例对象
     * @return 影响行数
     */
    int insert(RoleUser roleUser);

    /**
     * 修改数据
     *
     * @param roleUser 实例对象
     * @return 影响行数
     */
    int update(RoleUser roleUser);

    /**
     * 通过主键删除数据
     *
     * @param roleid 主键
     * @return 影响行数
     */
    int deleteById(Integer roleid);

}