package com.ehome.spring.cache.service;

import com.ehome.spring.cache.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by haoxiaolei on 2014/6/27 0027.
 */
public interface IUserService {

    User save(User user);

    int update(Map<String, Object> updateColumn, Map<String, Object> where);

    User update(User user);

    List<User> findList();
}
