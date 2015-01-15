package com.ehome.spring.jpa.controller;

import com.ehome.spring.jpa.module.User;
import com.ehome.spring.jpa.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author xiaolei
 * @date 2015-01-14 23:27
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object save(User user) {
        System.out.println(user.getName());
        return userService.save(user);
    }
}
