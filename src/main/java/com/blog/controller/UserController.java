package com.blog.controller;


import javax.servlet.http.HttpServletRequest;

import com.blog.entity.User;
import com.blog.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhouyang
 * Date 2018/4/25.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping(value = "/webUserShow",method = RequestMethod.GET)
    public String webUserShow(HttpServletRequest request, HttpServletResponse response){
        System.out.println("进来了");
        return "index";
    }

    @RequestMapping("/showUser")
    public User selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = userService.selectUser(userId);
        return user;
    }

    @RequestMapping("/login")
    public Boolean login(final User user,HttpServletRequest request, HttpServletResponse response) throws IOException {
        return userService.login(user);
    }

}
