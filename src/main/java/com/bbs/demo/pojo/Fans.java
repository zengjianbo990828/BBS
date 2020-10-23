package com.bbs.demo.pojo;

import java.io.Serializable;

/**
 * @Program: demo
 * @Description:粉丝实体类
 * @Author:zjb
 * @Date:2020/9/17 14:39
 * @Version 1.0
 */
public class Fans implements Serializable {
    private static final long serialVersionUID = -98381077804057414L;

    private Integer fansId;//粉丝Id

    public Integer getFansId() {
        return fansId;
    }

    public void setFansId(Integer fansId) {
        this.fansId = fansId;
    }


    @Override
    public String toString() {
        return "Fans{" +
                "fansId=" + fansId +
                '}';
    }
}