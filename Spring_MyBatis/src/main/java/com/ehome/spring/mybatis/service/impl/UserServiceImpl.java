package com.ehome.spring.mybatis.service.impl;

import com.ehome.spring.mybatis.dao.IUserDao;
import com.ehome.spring.mybatis.module.User;
import com.ehome.spring.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author haoxiaolei
 * @date 2015-02-14 22:29
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements IUserService {

    private IUserDao userDao;

    @Autowired
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public int save(User user) {
        return userDao.save(user);
    }

    public int update(User u) {
        return userDao.update(u);
    }
}
