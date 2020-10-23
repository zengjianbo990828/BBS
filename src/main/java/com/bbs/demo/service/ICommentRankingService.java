package com.bbs.demo.service;

import com.bbs.demo.entity.Comment;
import com.bbs.demo.entity.CommentRanking;

import java.util.List;

public interface ICommentRankingService {

    /**
     * 从mongodb中查询前十的评论
     * @param id
     * @param limit
     * @return
     */
    public List<CommentRanking> mongodbCommentRankingList(Integer id,Integer limit);

    /**
     * 查询排名前十的评论条数
     * @return
     */
    public List<Comment> commentRanking();


    /**
     * 添加前十评论最高
     * @return
     */
    public List<Comment> insertArticle();
}
