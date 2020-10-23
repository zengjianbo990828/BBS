package com.bbs.demo.pojo;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * @Program: demo
 * @Description:附件实体类
 * @Author:wzh
 * @Date:2020/9/17
 * @Version 1.0
 */
public class Accessory implements Serializable {
    private static final long serialVersionUID = -69193319426218458L;

    private Integer accessoryId;//附件Id

    private Integer uid;//关联用户Id

    private Double accessorySize;//附件大小

    private Blob accessory;//附件文件

    private Date accessoryDate;//附件上传日期

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(Integer accessoryId) {
        this.accessoryId = accessoryId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getAccessorySize() {
        return accessorySize;
    }

    public void setAccessorySize(Double accessorySize) {
        this.accessorySize = accessorySize;
    }

    public Blob getAccessory() {
        return accessory;
    }

    public void setAccessory(Blob accessory) {
        this.accessory = accessory;
    }

    public Date getAccessoryDate() {
        return accessoryDate;
    }

    public void setAccessoryDate(Date accessoryDate) {
        this.accessoryDate = accessoryDate;
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "accessoryId=" + accessoryId +
                ", uid=" + uid +
                ", accessorySize=" + accessorySize +
                ", accessory=" + accessory +
                ", accessoryDate=" + accessoryDate +
                '}';
    }
}