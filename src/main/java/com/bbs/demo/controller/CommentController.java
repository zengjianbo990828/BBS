package com.bbs.demo.controller;

import com.bbs.demo.entity.Comment;
import com.bbs.demo.service.ICommentService;
import com.bbs.demo.utils.constant.AttributeConstant;
import com.bbs.demo.utils.constant.MessageConstant;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    @Resource
    private ICommentService iCommentService;


    @GetMapping("/comment")
    public ModelAndView comment(Comment comment){
        ModelAndView modelAndView=new ModelAndView();
        List<Comment> commentList = iCommentService.findCommentList(comment);
        modelAndView.addObject("commentList",commentList);
        modelAndView.setViewName("comment");
        return modelAndView;
    }

    @PostMapping("/conComment")
    @ResponseBody
    public Comment conComment(Comment comment, HttpServletRequest request,Integer articleUserId){

//        request.getSession().getAttribute("");

        comment.setPhoto("255e2f6cbf2cd0ea6d66ba1c5e991f8f.jpg");

        if (comment.getUserId()==articleUserId){
            comment.setFlag(true);
        }


        Comment comment1 = iCommentService.insertConComment(comment, articleUserId);

        return comment1;
    }

    @PostMapping("/comment")
    @ResponseBody
    public Comment comment(Comment comment,HttpServletRequest request,Integer articleUserId){
        //测试
        Comment comment1=new Comment();
        comment1.setCommentId("1");
        comment1.setPostId(1);
        comment1.setUserId(1);
        comment1.setUserName("张三");
        comment1.setPhoto("255e2f6cbf2cd0ea6d66ba1c5e991f8f.jpg");

        if (comment1.getUserId()==articleUserId){
            comment1.setFlag(true);
        }
        request.getSession().setAttribute("comment",comment1);
        ModelAndView modelAndView=new ModelAndView();

        Comment comment2 = (Comment) request.getSession().getAttribute("comment");

        comment.setPhoto(comment2.getPhoto());
        comment.setUserId(comment2.getUserId());
        comment.setUserName(comment2.getUserName());
        comment.setPostId(comment2.getPostId());


        Comment comment3 = iCommentService.insertComment(comment, articleUserId);


        return comment3;
    }

    @PostMapping("/star")
    @ResponseBody
    public String star(Comment comment){

        String star = iCommentService.star(comment);

        return star;
    }

    @PostMapping("/deleteComment")
    @ResponseBody
    public String deleteComment(Comment comment){
        String s = iCommentService.deleteComment(comment);
        return s;
    }
}
