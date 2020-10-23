package com.bbs.demo.dao;

import com.bbs.demo.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ICommentDao {

    /**
     * 查询评论
     * @return
     */
    public List<Comment> findCommentList(Comment comment);

    /**
     * 添加评论
     * @param comment
     */
    public Comment insertComment(Comment comment);

    /**
     * 添加子评论
     * @param comment
     */
    public Comment insertConComment(Comment comment);

    /**
     * 删除评论
     * @param comment
     */
    public void deleteComment(Comment comment);

    /**
     * 查询排名前十的评论条数
     * @return
     */
    public List<Comment> commentRanking();

    /**
     * 点赞
     * @param comment
     */
    public void star(Comment comment);
}
