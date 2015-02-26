package com.ehome.spring.mybatis.dao.impl;

import com.ehome.spring.mybatis.dao.IUserDao;
import com.ehome.spring.mybatis.module.User;
import org.springframework.stereotype.Repository;

/**
 * Created by haoxiaolei on 2015-02-26 18:11
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements IUserDao {

    public int save(User user) {
        return 0;
    }

    public int update(User user) {
        System.out.println(user.getName());
        getSqlSession().update("com.ehome.spring.mybatis.dao.IUserDao.update", user);
        return 0;
    }
}
