package com.bbs.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRankingController {

    @RequestMapping({"/","/articleRanking"})
    public ModelAndView articleRanking(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("articleRanking");
        return modelAndView;
    }

    @RequestMapping("/commentRanking")
    public ModelAndView commentRanking(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("commentRanking");
        return modelAndView;
    }

    @RequestMapping("/userRanking")
    public ModelAndView userRanking(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("userRanking");
        return modelAndView;
    }
}
