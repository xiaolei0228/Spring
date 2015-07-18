package com.ehome.spring.mvc.test.dao;

import com.ehome.spring.mvc.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-06-29 13:20
 * @desc: 用spring-test和mockito不启动容器测试dao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserDaoTest {

    @InjectMocks
    @Resource
    private UserDao userDao;

    @Test
    public void getUserById() {
        userDao.getUserById(12L);
    }
}
