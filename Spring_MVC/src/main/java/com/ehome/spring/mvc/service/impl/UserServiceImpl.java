package com.ehome.spring.mvc.service.impl;

import com.ehome.spring.mvc.dao.UserDao;
import com.ehome.spring.mvc.module.User;
import com.ehome.spring.mvc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Project: Spring
 * @Title:
 * @Package com.ehome.spring.ioc.service
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/6/13 0013 23:01
 * @Copyright: 2014 ihome.com
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public User getUserById(Long id) {
        System.out.println("=============UserService.getUserById(88) Service层方法执行了...");
        return userDao.getUserById(id);
    }
}
