package com.ehome.spring_web.test.service;

import com.ehome.spring_web.module.User;
import com.ehome.spring_web.service.UserService;
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
 * @date: 2015-06-29 12:59
 * @desc: 用spring-test和mockito不启动容器测试service
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserServieTest {

    @InjectMocks
    @Resource
    private UserService userService;

    @Test
    public void getUserById() {
        User u = userService.getUserById(1L);
    }
}
