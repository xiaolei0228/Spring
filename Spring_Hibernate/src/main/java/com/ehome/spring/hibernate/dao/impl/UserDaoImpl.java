package com.ehome.spring.hibernate.dao.impl;

import com.ehome.spring.hibernate.dao.IUserDao;
import com.ehome.spring.hibernate.module.User;
import org.springframework.stereotype.Repository;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-04-22 10:48
 * @desc: 
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements IUserDao {
}
