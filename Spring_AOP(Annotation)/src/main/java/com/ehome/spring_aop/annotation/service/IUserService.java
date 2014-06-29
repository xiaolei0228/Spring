package com.ehome.spring_aop.annotation.service;

import com.ehome.spring_aop.annotation.module.User;

/**
 * Created by haoxiaolei on 2014/6/27 0027.
 */
public interface IUserService {

    boolean saveUser(User user);

    boolean updateUser(Long id) throws Exception;
}
