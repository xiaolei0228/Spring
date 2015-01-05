package com.ehome.spring_aop.xml.service.impl;

import com.ehome.spring_aop.xml.dao.IUserDao;
import com.ehome.spring_aop.xml.module.User;
import com.ehome.spring_aop.xml.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Project: Spring
 * @Title:
 * @Package com.ehome.spring_aop.xml.service
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/6/27 0027 22:42
 * @Copyright: 2014 ihome.com
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    public boolean saveUser(User user) {
        System.out.println("UserServiceImpl.saveUser()...");
        return userDao.saveUser(user);
    }

    public boolean updateUser(Long id) throws Exception {
        throw new Exception("更新 " + id + " 时出现错误了...");
    }
}
