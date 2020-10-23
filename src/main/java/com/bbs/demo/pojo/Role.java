package com.bbs.demo.pojo;

import java.io.Serializable;

/**
 * @Program: demo
 * @Description:角色实体类
 * @Author:zjb
 * @Date:2020/9/17
 * @Version 1.0
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 333109542399029058L;
    
    private Integer roleId;//角色Id

    private String roleName;//角色名称

    private String roleFlag;//角色标识符

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(String roleFlag) {
        this.roleFlag = roleFlag;
    }


    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleFlag='" + roleFlag + '\'' +
                '}';
    }
}