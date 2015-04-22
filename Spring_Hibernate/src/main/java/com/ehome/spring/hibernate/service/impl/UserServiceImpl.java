package com.ehome.spring.hibernate.service.impl;

import com.ehome.spring.hibernate.module.User;
import com.ehome.spring.hibernate.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-04-22 10:47
 * @desc: 
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements IUserService {
}
