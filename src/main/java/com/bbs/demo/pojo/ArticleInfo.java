package com.bbs.demo.pojo;

import javax.persistence.Entity;
import java.sql.Blob;
import java.util.Date;

/**
 * @Program: demo
 * @Description:文章实体类
 * @Author:wzh
 * @Date:2020/9/16 8:57
 * @Version 1.0
 */
public class ArticleInfo {

    private Integer postId;//文章Id
    private Integer articleTypeId;//文章类型Id
    private Integer uid;//用户Id
    private String title;//文章标题
    private String content;//文章内容
    private Date articleCreateDate;//文章创建时间
    private Date modifyDate;//文章修改时间
    private Integer toppingNumber;//是否置顶
    private Integer isPassword;//是否设置密码
    private Integer isComment;//是否可评论
    private String postPhoto;//文章封面图
    private Integer articleStatus;//状态：0未发布   1待审核    2已通过  3审核失败

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getArticleCreateDate() {
        return articleCreateDate;
    }

    public void setArticleCreateDate(Date articleCreateDate) {
        this.articleCreateDate = articleCreateDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getToppingNumber() {
        return toppingNumber;
    }

    public void setToppingNumber(Integer toppingNumber) {
        this.toppingNumber = toppingNumber;
    }

    public Integer getIsPassword() {
        return isPassword;
    }

    public void setIsPassword(Integer isPassword) {
        this.isPassword = isPassword;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public String getPostPhoto() {
        return postPhoto;
    }

    public void setPostPhoto(String postPhoto) {
        this.postPhoto = postPhoto;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    @Override
    public String toString() {
        return "Article{" +
                "postId=" + postId +
                ", articleTypeId=" + articleTypeId +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", articleCreateDate=" + articleCreateDate +
                ", modifyDate=" + modifyDate +
                ", toppingNumber=" + toppingNumber +
                ", isPassword=" + isPassword +
                ", isComment=" + isComment +
                ", postPhoto='" + postPhoto + '\'' +
                ", articleStatus=" + articleStatus +
                '}';
    }
}
