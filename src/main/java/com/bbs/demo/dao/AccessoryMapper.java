package com.bbs.demo.dao;

import com.bbs.demo.pojo.Accessory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Program: demo
 * @Description:附件数据访问接口
 * @Author:wzh
 * @Date:2020/9/17
 * @Version 1.0
 */
@Repository
public interface AccessoryMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param accessoryid 主键
     * @return 实例对象
     */
    Accessory queryById(Integer accessoryid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Accessory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param accessory 实例对象
     * @return 对象列表
     */
    List<Accessory> queryAll(Accessory accessory);

    /**
     * 新增数据
     *
     * @param accessory 实例对象
     * @return 影响行数
     */
    int insert(Accessory accessory);

    /**
     * 修改数据
     *
     * @param accessory 实例对象
     * @return 影响行数
     */
    int update(Accessory accessory);

    /**
     * 通过主键删除数据
     *
     * @param accessoryid 主键
     * @return 影响行数
     */
    int deleteById(Integer accessoryid);

}