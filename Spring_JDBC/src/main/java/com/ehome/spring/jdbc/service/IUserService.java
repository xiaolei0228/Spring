package com.ehome.spring.jdbc.service;

import com.ehome.spring.jdbc.module.User;

import java.util.List;

/**
 * Created by haoxiaolei on 2014/6/27 0027.
 */
public interface IUserService {

    User save(User user);

    List<User> findList();

}
