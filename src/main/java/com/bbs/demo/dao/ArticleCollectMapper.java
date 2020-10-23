package com.bbs.demo.dao;

import com.bbs.demo.pojo.ArticleCollect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Program: demo
 * @Description:文章&我的点赞、收藏数据访问接口
 * @Author:wzh
 * @Date:2020/9/17
 * @Version 1.0
 */
@Repository
public interface ArticleCollectMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param postid 主键
     * @return 实例对象
     */
    ArticleCollect queryById(Integer postid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ArticleCollect> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param articleCollect 实例对象
     * @return 对象列表
     */
    List<ArticleCollect> queryAll(ArticleCollect articleCollect);

    /**
     * 新增数据
     *
     * @param articleCollect 实例对象
     * @return 影响行数
     */
    int insert(ArticleCollect articleCollect);

    /**
     * 修改数据
     *
     * @param articleCollect 实例对象
     * @return 影响行数
     */
    int update(ArticleCollect articleCollect);

    /**
     * 通过主键删除数据
     *
     * @param postid 主键
     * @return 影响行数
     */
    int deleteById(Integer postid);

}