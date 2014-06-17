package com.ehome.spring_web.controller;

import com.ehome.spring_web.module.User;
import com.ehome.spring_web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Project: Spring
 * @Title:
 * @Package com.ehome.spring_web.controller
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/6/14 0014 23:57
 * @Copyright: 2014 ihome.com
 */
@Controller()
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserById(String id) {
        System.out.println("UserController.getUserById()......");
        User user = userService.getUserById(1L);
        return user;
    }
}
