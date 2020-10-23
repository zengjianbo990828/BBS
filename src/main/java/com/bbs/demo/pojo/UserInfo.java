package com.bbs.demo.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Program: demo
 * @Description:用户信息实体类
 * @Author:hjm
 * @Date:2020/9/17
 * @Version 1.0
 */
@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer uid;//主键id

    private String userName;//用户名，不可用于登录
    private String password;//密码
    private String mobilPhone;//手机号
    private String email;//邮箱
    private String photo;//头像
    private String introduction;//简介
    private Integer integral;//个人积分
    private Float money;//余额
    private Integer userStatus;//用户状态
    private Date userCreateDate;//创建时间
    private Integer seeNumber;//查看次数
    private String sex;//性别

    public UserInfo() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex =  sex;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilPhone() {
        return mobilPhone;
    }

    public void setMobilPhone(String mobilPhone) {
        this.mobilPhone = mobilPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Date userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public Integer getSeeNumber() {
        return seeNumber;
    }

    public void setSeeNumber(Integer seeNumber) {
        this.seeNumber = seeNumber;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mobilPhone='" + mobilPhone + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", introduction='" + introduction + '\'' +
                ", integral=" + integral +
                ", money=" + money +
                ", userStatus=" + userStatus +
                ", userCreateDate=" + userCreateDate +
                ", seeNumber=" + seeNumber +
                '}';
    }
}
