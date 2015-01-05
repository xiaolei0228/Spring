package com.ehome.spring_tx.service;


import com.ehome.spring_tx.module.User;

import java.util.List;

/**
 * Created by haoxiaolei on 2014/6/27 0027.
 */
public interface IUserService {

    boolean saveUser(User user);

    boolean updateUser(Long id) throws Exception;

    List<User> findList();

}
