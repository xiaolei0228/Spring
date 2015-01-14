package com.ehome.spring.jpa.service;

import com.ehome.spring.jpa.module.User;

import java.util.List;

/**
 * Created by haoxiaolei on 2014/6/27 0027.
 */
public interface IUserService {

    boolean save(User user);

    boolean update(User user);

    boolean delete(Long id);

    List<User> findList();

}
