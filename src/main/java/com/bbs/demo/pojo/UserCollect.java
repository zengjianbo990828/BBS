package com.bbs.demo.pojo;

import java.io.Serializable;

/**
 * @Program: demo
 * @Description:用户&我的点赞、收藏实体类
 * @Author:zjb
 * @Date:2020/9/17
 * @Version 1.0
 */
public class UserCollect implements Serializable {
    private static final long serialVersionUID = -83679175908785172L;

    private String id;//我的点赞、收藏Id

    private Integer uid;//用户Id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserCollect{" +
                "id='" + id + '\'' +
                ", uid=" + uid +
                '}';
    }
}