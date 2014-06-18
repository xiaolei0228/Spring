package com.ehome.spring.ioc.service.impl;

import com.ehome.spring.ioc.dao.UserDao;
import com.ehome.spring.ioc.module.User;
import com.ehome.spring.ioc.service.UserService;
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
    // ioc 注解方式只需要这样就可以找到对应的bean了...
    @Resource
    private UserDao userDao;

    public User getUserById(Long id) {
        System.out.println("=============UserService.getUserById(88) Service层方法执行了...");
        userDao.getUserById(id);
        return null;
    }
}
