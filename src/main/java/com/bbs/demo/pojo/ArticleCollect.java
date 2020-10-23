package com.bbs.demo.pojo;

import java.io.Serializable;

/**
 * @Program: demo
 * @Description:文章&我的点赞、收藏关系实体类
 * @Author:wzh
 * @Date:2020/9/17
 * @Version 1.0
 */
public class ArticleCollect implements Serializable {
    private static final long serialVersionUID = -53046682367233316L;

    private Integer postId;//文章id

    private String id;//点赞、收藏id

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ArticleCollect{" +
                "postId=" + postId +
                ", id='" + id + '\'' +
                '}';
    }
}