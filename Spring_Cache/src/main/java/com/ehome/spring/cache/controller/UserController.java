package com.ehome.spring.cache.controller;

import com.ehome.spring.cache.entity.User;
import com.ehome.spring.cache.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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

    @RequestMapping("save")
    @ResponseBody
    public Object save(User user) {
        return userService.save(user);
    }

    @RequestMapping("update")
    @ResponseBody
    public Object update(User user) {
        try {
            userService.update(user);
        } catch (Exception e) {
            System.err.println("捕获到的异常信息---->" + e);
        }
        return user;
    }

    @RequestMapping("findList")
    @ResponseBody
    public Object findList() {
        List<User> userList = userService.findList();
        for (User user : userList) {
            System.out.println(user.getName());
        }

        return userList;
    }

}
