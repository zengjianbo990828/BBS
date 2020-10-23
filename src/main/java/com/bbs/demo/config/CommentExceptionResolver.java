package com.bbs.demo.config;

import com.bbs.demo.utils.constant.AttributeConstant;
import com.bbs.demo.utils.exception.CommentException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class CommentExceptionResolver {

    @ExceptionHandler(value = CommentException.class)
    public ModelAndView CommentException(Exception e,HttpServletRequest request,HttpServletResponse response){
        return this.commonsHandler(e,request,response,"/error","error.html");
    };

    /**
     * 错误信息封装
     * @param e 错误信息
     * @param request
     * @param response
     * @param viewName 跳转的页面
     * @return
     */
    public ModelAndView commonsHandler(Exception e, HttpServletRequest request, HttpServletResponse response, String viewName, String prePageName){
        //读取信息
        String message=e.getMessage();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject(AttributeConstant.ATTR_NAME_EXCEPTION_INFORMATION,message);
        modelAndView.setViewName(viewName);

        /**
         *判断是否需要跳转
         */
        if (StringUtils.isEmpty(prePageName)){
            String referer = request.getHeader("Referer");
            prePageName=referer;
        }
        modelAndView.addObject(AttributeConstant.Attr_NAME_PRE_PAGE_NAME,prePageName);

        return modelAndView;
    }
}
