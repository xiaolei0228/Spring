package com.ehome.spring.jdbc.dao;

import com.ehome.spring.jdbc.module.User;

import java.util.List;

/**
 * Created by haoxiaolei on 2014/6/13 0013.
 */
public interface IUserDao {
    public User getById(Long id);

    User save(User user);

    List findList();
}
