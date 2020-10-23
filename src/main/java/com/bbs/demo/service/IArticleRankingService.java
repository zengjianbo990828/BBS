package com.bbs.demo.service;

import com.bbs.demo.entity.ArticleRanking;

import java.util.List;

public interface IArticleRankingService {
    /**
     * 查询所有点赞数最高的文章
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
