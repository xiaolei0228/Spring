package com.ehome.spring.ioc.dao;

import com.ehome.spring.ioc.module.User;

/**
 * Created by haoxiaolei on 2014/6/13 0013.
 */
public interface UserDao {
    public User getUserById(Long id);
}
