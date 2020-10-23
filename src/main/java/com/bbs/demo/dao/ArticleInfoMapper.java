package com.bbs.demo.dao;

import com.bbs.demo.pojo.ArticleInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Program: demo
 * @Description:文章信息数据访问接口
 * @Author:wzh
 * @Date:2020/9/17
 * @Version 1.0
 */
@Repository
public interface ArticleInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param postid 主键
     * @return 实例对象
     */
    ArticleInfo queryById(Integer postid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ArticleInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param articleInfo 实例对象
     * @return 对象列表
     */
    List<ArticleInfo> queryAll(ArticleInfo articleInfo);

    /**
     * 新增数据
     *
     * @param articleInfo 实例对象
     * @return 影响行数
     */
    int insert(ArticleInfo articleInfo);

    /**
     * 修改数据
     *
     * @param articleInfo 实例对象
     * @return 影响行数
     */
    int update(ArticleInfo articleInfo);

    /**
     * 通过主键删除数据
     *
     * @param postid 主键
     * @return 影响行数
     */
    int deleteById(Integer postid);

}