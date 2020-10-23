package com.bbs.demo.pojo;

import java.io.Serializable;

/**
 * @Program: demo
 * @Description:我的点赞、收藏实体类
 * @Author:zjb
 * @Date:2020/9/17 14:39
 * @Version 1.0
 */
public class Collect implements Serializable {
    private static final long serialVersionUID = 116666051129572379L;

    private String id;//我的点赞、收藏Id

    private Integer starStatus;//我的点赞状态码

    private Integer favoritesStatus;//我的收藏状态码

    private String collectDate;//创建时间

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStarStatus() {
        return starStatus;
    }

    public void setStarStatus(Integer starStatus) {
        this.starStatus = starStatus;
    }

    public Integer getFavoritesStatus() {
        return favoritesStatus;
    }

    public void setFavoritesStatus(Integer favoritesStatus) {
        this.favoritesStatus = favoritesStatus;
    }

    public String getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(String collectDate) {
        this.collectDate = collectDate;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id='" + id + '\'' +
                ", starStatus=" + starStatus +
                ", favoritesStatus=" + favoritesStatus +
                ", collectDate='" + collectDate + '\'' +
                '}';
    }
}