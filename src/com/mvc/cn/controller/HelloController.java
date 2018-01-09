package com.mvc.cn.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * Created by liKun on 2017/12/29 0029.
 */
public class HelloController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("hello");
        System.out.println("handlerRequest-----------");
        return modelAndView;
    }
}
