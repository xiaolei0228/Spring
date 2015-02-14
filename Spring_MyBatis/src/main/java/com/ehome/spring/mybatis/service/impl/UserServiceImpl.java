package com.ehome.spring.mybatis.service.impl;

import com.ehome.spring.mybatis.module.User;
import com.ehome.spring.mybatis.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author haoxiaolei
 * @date 2015-02-14 22:29
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements IUserService {


}
