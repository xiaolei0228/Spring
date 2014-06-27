package com.ehome.spring_aop.annotation.dao;

import com.ehome.spring_aop.annotation.module.User;

/**
 * Created by haoxiaolei on 2014/6/13 0013.
 */
public interface IUserDao {
    public User getUserById(Long id);

    boolean saveUser(User user);
}
