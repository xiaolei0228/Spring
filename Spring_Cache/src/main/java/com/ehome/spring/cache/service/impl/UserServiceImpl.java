package com.ehome.spring.cache.service.impl;

import com.ehome.spring.cache.dao.IUserDao;
import com.ehome.spring.cache.entity.User;
import com.ehome.spring.cache.service.IUserService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @CachePut(value = "user")
    public User save(User user) {
        return userDao.save(user);
    }

    public int update(Map<String, Object> updateColumn, Map<String, Object> where) {
        return userDao.update(updateColumn, where);
    }

    @CachePut(value = "user")
    public User update(User user) {
        List<User> userList = userDao.findList();
        for (User u : userList) {
            System.out.println(u.getMobile());
        }
        userDao.update(user);
        return user;
    }


    @Cacheable(value = "user")
    public List<User> findList() {
        System.out.println("findList caching...");
        return userDao.findList();
    }


}
