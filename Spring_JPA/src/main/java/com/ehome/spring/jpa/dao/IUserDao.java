package com.ehome.spring.jpa.dao;


import com.ehome.spring.jpa.module.User;

import java.util.List;

/**
 * Created by haoxiaolei on 2014/6/13 0013.
 */
public interface IUserDao {
    boolean save(User user);

    boolean update(User user);

    boolean delete(Long id);

    List<User> findList();
}
