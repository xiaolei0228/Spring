package com.ehome.spring.shiro.controller;

import com.ehome.spring.shiro.module.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring
 *
 * @author: haoxiaolei
 * @date: 2015-05-04 23:45
 * @desc: 
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("hello")
    public String hello(Model model) {
        User user = new User();
        user.setUsername("spring_shiro...");

        model.addAttribute("user", user);

        return "hello";
    }
}
