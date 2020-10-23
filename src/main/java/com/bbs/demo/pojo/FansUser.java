package com.bbs.demo.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * @Program: demo
 * @Description:粉丝&用户实体类
 * @Author:zjb
 * @Date:2020/9/17
 * @Version 1.0
 */
public class FansUser implements Serializable {
    private static final long serialVersionUID = 224548647812787103L;
    
    private Integer fansId;//粉丝Id

    private Integer uid;//用户Id

    private Date date;//点赞或收藏时间


    public Integer getFansId() {
        return fansId;
    }

    public void setFansId(Integer fansId) {
        this.fansId = fansId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "FansUser{" +
                "fansId=" + fansId +
                ", uid=" + uid +
                ", date=" + date +
                '}';
    }
}