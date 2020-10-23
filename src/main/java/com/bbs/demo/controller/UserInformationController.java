package com.bbs.demo.controller;

import com.bbs.demo.pojo.FansUser;
import com.bbs.demo.pojo.UserInfo;
import com.bbs.demo.service.IFansUserService;
import com.bbs.demo.service.IUserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: 曾建波
 * @date: 2020-09-25
 * @description: 个人管理控制层
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bbs.demo.controller
 */
@Controller
public class UserInformationController {

    @Resource
    private IUserInfoService userInfoService;
    @Resource
    private IFansUserService fansUserService;

    //用户管理
    @RequestMapping("/Personal")
    public String Personal() {
        return "person/personal";
    }

    //当前用户信息
    @RequestMapping("/UserInfo")
    public ModelAndView UserInfo(UserInfo userInfo, Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfos = userInfoService.queryUserInfo(userInfo);
        modelAndView.addObject("userInfos", userInfos);
        modelAndView.setViewName("person/userInfo");
        return modelAndView;
    }

    //修改当前用户信息
    @RequestMapping("/updateUser")
    public ModelAndView updateUser(UserInfo userInfo) {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo queryUserInfo = userInfoService.queryUserInfo(userInfo);
        modelAndView.addObject("queryUserInfo", queryUserInfo);
        modelAndView.setViewName("person/changeMsg");
        return modelAndView;
    }

    //修改信息
    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(UserInfo userInfo) {
        Integer integer = this.userInfoService.updateUserInfo(userInfo);
        if (integer == -1) {
            return "redirect:/updateUser";
        }
        return "forward:/UserInfo";
    }

    //查询当前用户的粉丝以及粉丝数量
    @RequestMapping("/queryUsersFans")
    public ModelAndView queryUsersFans(FansUser fansUser) {
        ModelAndView modelAndView = new ModelAndView();
        List<String> fansUsers = this.fansUserService.queryFansList(fansUser);
        Integer integer = this.fansUserService.queryFansNum(fansUser.getUid());
        modelAndView.addObject("integer", integer);
        modelAndView.addObject("fansUsers", fansUsers);
        modelAndView.setViewName("person/fans");
        return modelAndView;
    }

    //查询当前用户的关注
    @RequestMapping("/queryUserConcern")
    public ModelAndView queryUserConcern(FansUser fansUser) {
        ModelAndView modelAndView = new ModelAndView();
        List<Map> fansUserCon = this.fansUserService.queryUserConcern(fansUser);
        Integer integer = this.fansUserService.queryConcernNum(fansUser.getUid());
        modelAndView.addObject("integer", integer);
        modelAndView.addObject("fansUserCon", fansUserCon);
        modelAndView.setViewName("person/Concern");
        return modelAndView;
    }

    //查询当前用户的文章被点赞情况
    @RequestMapping("/queryUserLikeInfo")
    public ModelAndView queryUserLikeInfo(FansUser fansUser){
        ModelAndView modelAndView = new ModelAndView();
        List<Map> mapList = this.fansUserService.queryLikeInfo(fansUser);
        modelAndView.addObject("mapList",mapList);
        modelAndView.setViewName("person/Like");
        return modelAndView;
    }
}
