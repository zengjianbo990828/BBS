package com.bbs.demo.controller;

import com.bbs.demo.pojo.UserInfo;
import com.bbs.demo.service.IUserInfoService;
import com.bbs.demo.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserInfoController {

    @Resource
    private IUserInfoService userInfoService;

    private String Code="000000";

    //登录页面跳转
    @GetMapping("/index")
    public String index(){
        return "login/login";
    }

    //注册用户链接跳转
    @GetMapping("/register")
    public String register(){
        return  "login/register";
    }

    //修改密码链接跳转
    @GetMapping("/password")
    public String password(){
        return "login/password";
    }


    //获取验证码
    @GetMapping("/code")
    @ResponseBody
    public String Codes(String phone,Integer reader){
        UserInfo userInfo=new UserInfo();
        userInfo.setMobilPhone(phone);
        System.out.println("手机号是："+phone);
        UserInfo user=userInfoService.queryUserInfo(userInfo);
        //0==注册

        if (reader==0){
            System.out.println("这是注册");
            if (user==null){
                Code=HttpUtils.smsCode();
            }else {
                Code="000000";
            }
        }else{
            System.out.println("这是忘记密码！");
            System.out.println(user);
            if(user!=null){
                Code=HttpUtils.smsCode();
            }else {
                Code="000000";
            }
        }

        return Code;
    };

    //登录验证
    @PostMapping("/loginform")
    public ModelAndView loginform(String userName, String password, HttpSession session){
        ModelAndView modelAndView=new ModelAndView();
//        System.out.println(userName);
//        System.out.println(password);

        UserInfo user=new UserInfo();
        user.setMobilPhone(userName);

        UserInfo userInfo = userInfoService.queryUserInfo(user);

        //保存前台输入，方便传回
        modelAndView.addObject("userName",userName);
        modelAndView.addObject("passwrod",password);

        //判断用户是否存在
        if(userInfo!=null){
            //判断密码是否正确
            if (userInfo.getPassword().equals(password)){
                //保存Session
                session.setAttribute("userName",userName);
                modelAndView.setViewName("/index");
            }else {
                modelAndView.addObject("errorP","密码错误！");
                modelAndView.setViewName("login/login");
            }
        }else {
            modelAndView.addObject("errorN","用户不存在！");
            modelAndView.setViewName("login/login");
        }
        // redirect 重定向
        return modelAndView;
    }


    //验证码验证
    @PostMapping("/phoneForm")
    public ModelAndView phoneForm(String mobilPhone,String code,Integer reader){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("phones",mobilPhone);

        UserInfo userInfo=new UserInfo();
        userInfo.setMobilPhone(mobilPhone);

        UserInfo user=this.userInfoService.queryUserInfo(userInfo);

        //reader==0==注册验证码验证
        if (reader==0){
            System.out.println("这是注册验证码验证");
            if (user==null){
                if (!Code.equals(code)) {
                    modelAndView.addObject("CodeY", "验证码错误");
                }else{
                    modelAndView.addObject("phone",mobilPhone);
                }
            }else{
                modelAndView.addObject("phoneY","该用户已被注册");
            }
            modelAndView.setViewName("/login/register");
        }else{
            System.out.println("这是忘记密码验证");
            if(user!=null){
                if (!Code.equals(code)) {
                    modelAndView.addObject("CodeY", "验证码错误");
                }else{
                    modelAndView.addObject("phone",mobilPhone);
                }
            }else{
                modelAndView.addObject("phoneY","该用户不存在");
            }
            modelAndView.setViewName("/login/password");
            }
        return  modelAndView;
    }

    @PostMapping("/userInfoForm")
    public String userInfoForm(UserInfo userInfo){
        System.out.println(userInfo.getUserName()+"***"+userInfo.getMobilPhone()+"***"+userInfo.getPassword());
        userInfoService.addUserInfo(userInfo);
        return "login/login";
    }

    @PostMapping("/passwordForm")
    public String passwordForm(UserInfo userInfo){
        System.out.println(userInfo.getMobilPhone()+"***"+userInfo.getPassword());
        this.userInfoService.updateUserInfo(userInfo);
        return "login/login";
    }

}
