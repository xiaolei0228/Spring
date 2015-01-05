package com.ehome.spring_tx.dao.impl;

import com.ehome.spring_tx.dao.IUserDao;
import com.ehome.spring_tx.module.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    JdbcTemplate jdbcTemplate;

    public User getUserById(Long id) {
        System.out.println("=============IUserDao.getUserById(88) Dao层方法执行了...");
        User user = new User();
        user.setId(id);
        user.setName("单车上的理想");
        return user;
    }

    public boolean saveUser(User user) {
        int result = jdbcTemplate.update("INSERT INTO t_user(name, sex, mobile) VALUES ('" + user.getName() + "'," + user.getSex() + ",'" + user.getMobile() + "')");
        return result > 0;
    }

    public List<User> findList() {
        return null;
    }
}
