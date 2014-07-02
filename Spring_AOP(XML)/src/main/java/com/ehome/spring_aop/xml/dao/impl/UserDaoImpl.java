package com.ehome.spring_aop.xml.dao.impl;

import com.ehome.spring_aop.xml.dao.IUserDao;
import com.ehome.spring_aop.xml.module.User;
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
public class UserDaoImpl implements IUserDao {

    public User getUserById(Long id) {
        System.out.println("=============IUserDao.getUserById(88) Dao层方法执行了...");
        User user = new User();
        user.setId(id);
        user.setName("单车上的理想");
        user.setPassword("xiaolei-0228");
        user.setEnable(true);
        return user;
    }

    public boolean saveUser(User user) {
        return false;
    }
}
