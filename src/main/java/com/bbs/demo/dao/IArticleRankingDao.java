package com.bbs.demo.dao;

import com.bbs.demo.entity.ArticleRanking;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface IArticleRankingDao {

    /**
     * 查询所有点赞数最高前10的文章
     * @return
     */
    public List<ArticleRanking> findArticleAll(Integer id,Integer limit);

    /**
     * 添加前十点赞最高
     * @param articleRanking
     * @return
     */
    public void insertArticle(ArticleRanking articleRanking);
}
