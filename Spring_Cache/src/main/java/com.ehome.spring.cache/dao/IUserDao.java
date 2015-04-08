package com.ehome.spring.cache.dao;

import com.ehome.spring.cache.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by haoxiaolei on 2014/6/13 0013.
 */
public interface IUserDao {

    User save(User user);

    /**
     * 动态更新字段
     *  @param updateColumn 要更新的字段
     * @param where        where条件
     */
    int update(Map<String, Object> updateColumn, Map<String, Object> where);

    User update(User user);

    List findList();

    User findById(Long id);
}
