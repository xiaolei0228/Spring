package com.ehome.spring.ioc.dao.impl;

import com.ehome.spring.ioc.dao.UserDao;
import com.ehome.spring.ioc.module.User;
import org.springframework.stereotype.Repository;

/**
 * @version V1.0
 * @Project: Spring
 * @Title:
 * @Package com.ehome.spring.ioc.dao.impl
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/6/13 0013 23:33
 * @Copyright: 2014 ihome.com
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    public User getUserById(Long id) {
        System.out.println("=============UserDao.getUserById(88) Dao层方法执行了...");
        return null;
    }
}
