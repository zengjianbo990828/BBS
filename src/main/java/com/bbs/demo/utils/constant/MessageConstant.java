package com.bbs.demo.utils.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 异常信息
 */
public class MessageConstant {

    /**
     * 账号为空
     */
    public static final String MESSAGE_ACCOUNT_IS_EMPTY="页面过期，请重新登录！";

    /**
     * 评论失败
     */
    public static final String MESSAGE_SAVE_FAILED="评论失败！";

    /**
     * 评论加载失败
     */
    public static final String MESSAGE_LOADING_FAILED="评论加载失败！";

    /**
     * 请先登录
     */
    public static final String MESSAGE_NOT_LOGGED_IN="请先登录！";

    //关键字
    public static final String MESSAGE_KEYWORD="评论不允许有关键字！";

    /**
     * 检索字符串是否有关键字
     * @param content
     */
    public static final String CHARACTER_RETRIEVAL(String content){
        List<String> list=new ArrayList<String>();
        list.add("傻逼");
        list.add("垃圾");
        list.add("操");

        for (String retrieval : list) {
            if (content.indexOf(retrieval)!=-1){

                return MessageConstant.MESSAGE_KEYWORD;
            }
        }
        return "";
    }

    /**
     *  点赞失败
     */
    public static final String MESSAGE_STAR="点赞失败";

    /**
     * 删除失败
     */
    public static final String MESSAGE_DELETE="删除失败！";
}
