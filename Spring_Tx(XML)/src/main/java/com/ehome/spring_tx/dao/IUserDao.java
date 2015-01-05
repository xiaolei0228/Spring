package com.ehome.spring_tx.dao;


import com.ehome.spring_tx.module.User;

import java.util.List;

/**
 * Created by haoxiaolei on 2014/6/13 0013.
 */
public interface IUserDao {
    public User getUserById(Long id);

    boolean saveUser(User user);

    List<User> findList();
}
