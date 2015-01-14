package com.ehome.spring.jpa.service.impl;

import com.ehome.spring.jpa.dao.IUserDao;
import com.ehome.spring.jpa.module.User;
import com.ehome.spring.jpa.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author  xiaolei
 * @date    2015-01-14 23:48
 * To change this template use File | Settings | File Templates. 
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public boolean save(User user) {
        return userDao.save(user);
    }

    public boolean update(User user) {
        return false;
    }

    public boolean delete(Long id) {
        return false;
    }

    public List<User> findList() {
        return null;
    }
}
