package com.bbs.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Program: demo
 * @Description:文章类型实体类
 * @Author:wzh
 * @Date:2020/9/17 14:39
 * @Version 1.0
 */
public class ArticleType {
    private Integer articleTypeId;//一级类型Id
    private Integer articleTypePid;//二级类型Id
    private String articleTypeName;//类型名称

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public Integer getArticleTypePid() {
        return articleTypePid;
    }

    public void setArticleTypePid(Integer articleTypePid) {
        this.articleTypePid = articleTypePid;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    @Override
    public String toString() {
        return "ArticleType{" +
                "articleTypeId=" + articleTypeId +
                ", articleTypePid=" + articleTypePid +
                ", articleTypeName='" + articleTypeName + '\'' +
                '}';
    }
}
