package com.ehome.spring.mybatis.service;

import com.ehome.spring.mybatis.module.User;

/**
 * @author haoxiaolei
 * @date 2015-02-14
 */
public interface IUserService extends IBaseService<User, Long> {

    int save(User user);

}
