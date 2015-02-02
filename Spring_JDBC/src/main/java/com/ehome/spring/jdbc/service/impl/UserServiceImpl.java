package com.ehome.spring.jdbc.service.impl;

import com.ehome.spring.jdbc.dao.IUserDao;
import com.ehome.spring.jdbc.module.User;
import com.ehome.spring.jdbc.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public User save(User user) {
        return userDao.save(user);
    }

    public List<User> findList() {
        return userDao.findList();
    }
}
