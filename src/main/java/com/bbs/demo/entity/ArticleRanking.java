package com.bbs.demo.entity;

import java.io.Serializable;

/**
 * @Program: demo
 * @Description:文章排行榜实体类
 * @Author:wzh
 * @Date:2020/9/17
 * @Version 1.0
 */
public class ArticleRanking implements Serializable {
    private Integer id;//文章id
    private String postTitle;//标题
    private String content;//内容
    private Integer postStar;//评论数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPostStar() {
        return postStar;
    }

    public void setPostStar(Integer postStar) {
        this.postStar = postStar;
    }
}
