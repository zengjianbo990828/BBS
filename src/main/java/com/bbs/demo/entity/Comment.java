package com.bbs.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * 评论
 */
@Document(collection = "comment")
public class Comment {
    @Id
    private String id;//id
    private String commentId;//评论id
    private Integer postId;//文章id
    private Integer userId;//用户id
    private String userName;//用户名
    private String photo;//头像
    private Date createDate;//发表时间
    private boolean flag=false;//是否是本人
    private Integer star=0;//点赞数
    private String content;//评论内容
    private Integer commentSize=1;//评论数
    private Integer commentCon=0;//是否是子评论 1为是子评论
    private boolean whetherStar=false;//是否已经点赞

    private List<Comment> commentObjects;//子评论
//    @Transient
    private Integer replyId;//回复id
    private String replyName;//回复名

    public boolean isWhetherStar() {
        return whetherStar;
    }

    public void setWhetherStar(boolean whetherStar) {
        this.whetherStar = whetherStar;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", commentId='" + commentId + '\'' +
                ", postId=" + postId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", photo='" + photo + '\'' +
                ", createDate=" + createDate +
                ", flag=" + flag +
                ", star=" + star +
                ", content='" + content + '\'' +
                ", commentSize=" + commentSize +
                ", commentCon=" + commentCon +
                ", commentObjects=" + commentObjects +
                ", replyId=" + replyId +
                ", replyName='" + replyName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommentSize() {
        return commentSize;
    }

    public void setCommentSize(Integer commentSize) {
        this.commentSize = commentSize;
    }

    public Integer getCommentCon() {
        return commentCon;
    }

    public void setCommentCon(Integer commentCon) {
        this.commentCon = commentCon;
    }

    public List<Comment> getCommentObjects() {
        return commentObjects;
    }

    public void setCommentObjects(List<Comment> commentObjects) {
        this.commentObjects = commentObjects;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }
}
