package com.bbs.demo.dao;

import com.bbs.demo.pojo.Fans;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Program: demo
 * @Description:粉丝数据访问接口
 * @Author:wzh
 * @Date:2020/9/17
 * @Version 1.0
 */
public interface FansMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param fansid 主键
     * @return 实例对象
     */
    Fans queryById(Integer fansid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Fans> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param fans 实例对象
     * @return 对象列表
     */
    List<Fans> queryAll(Fans fans);

    /**
     * 新增数据
     *
     * @param fans 实例对象
     * @return 影响行数
     */
    int insert(Fans fans);

    /**
     * 修改数据
     *
     * @param fans 实例对象
     * @return 影响行数
     */
    int update(Fans fans);

    /**
     * 通过主键删除数据
     *
     * @param fansid 主键
     * @return 影响行数
     */
    int deleteById(Integer fansid);

}