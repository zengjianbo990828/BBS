package com.bbs.demo.pojo;

import java.io.Serializable;

/**
 * @Program: demo
 * @Description:角色&用户实体类
 * @Author:zjb
 * @Date:2020/9/17
 * @Version 1.0
 */
public class RoleUser implements Serializable {
    private static final long serialVersionUID = -60537449453824692L;
    
    private Integer roleId;//角色Id

    private Integer uid;//用户Id

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }


    @Override
    public String toString() {
        return "RoleUser{" +
                "roleId=" + roleId +
                ", uid=" + uid +
                '}';
    }
}