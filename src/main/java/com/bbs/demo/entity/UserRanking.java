package com.bbs.demo.entity;

import java.io.Serializable;

/**
 * @Program: demo
 * @Description:用户排行榜实体类
 * @Author:wzh
 * @Date:2020/9/17
 * @Version 1.0
 */
public class UserRanking implements Serializable {
    private Integer uUID;//用户id
    private String userName;//用户名
    private String briefIntroduction;//简介
    private String photo;//头像
    private Integer yesterdayFanSize;//昨日粉丝数量
    private Integer totalFansSize;//总粉丝数
    private Integer totalStar;//总点赞数
}
