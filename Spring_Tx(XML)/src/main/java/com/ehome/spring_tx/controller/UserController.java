package com.ehome.spring_tx.controller;

import com.ehome.spring_tx.module.User;
import com.ehome.spring_tx.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Project: Spring
 * @Title:
 * @Package com.ehome.spring_aop.annotation
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/6/27 0027 23:23
 * @Copyright: 2014 ihome.com
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/saveUser")
    @ResponseBody
    public Object saveUser(User user) {
        return userService.saveUser(user);
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Object updateUser(Long id) {
        try {
            userService.updateUser(id);
        } catch (Exception e) {
            System.err.println("捕获到的异常信息---->" + e);
        }
        return id;
    }

    @RequestMapping("/findList")
    @ResponseBody
    public Object findList() {
        return userService.findList();
    }

}
