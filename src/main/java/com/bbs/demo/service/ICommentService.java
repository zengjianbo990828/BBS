package com.bbs.demo.service;

import com.bbs.demo.entity.Comment;

import java.util.List;

public interface ICommentService {
    /**
     * 查询评论
     * @return
     */
    public List<Comment> findCommentList(Comment comment);

    /**
     * 添加评论
     * @param comment
     */
    public Comment insertComment(Comment comment,Integer userId);

    /**
     * 添加子评论
     * @param comment
     */
    public Comment insertConComment(Comment comment,Integer userId);

    /**
     * 删除评论
     * @param comment
     * @return
     */
    public String deleteComment(Comment comment);

    /**
     * 点赞
     * @param comment
     */
    public String star(Comment comment);
}
