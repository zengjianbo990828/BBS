package com.bbs.demo.entity;

import java.io.Serializable;

/**
 * @Program: demo
 * @Description:评论实体类
 * @Author:pb
 * @Date:2020/9/17
 * @Version 1.0
 */
public class CommentRanking implements Serializable {
    private Integer postId;//评论id
    private String postTitle;//标题
    private String content;//内容
    private Integer commentsSize;//评论数

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommentsSize() {
        return commentsSize;
    }

    public void setCommentsSize(Integer commentsSize) {
        this.commentsSize = commentsSize;
    }
}
