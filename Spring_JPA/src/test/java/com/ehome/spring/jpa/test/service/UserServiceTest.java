package com.ehome.spring.jpa.test.service;

import com.ehome.spring.jpa.module.User;
import com.ehome.spring.jpa.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by haoxiaolei on 2015-01-28 17:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserServiceTest {

    @Resource
    private IUserService userService;

    @Test
    public void save() {
        User user = new User();
        user.setName("写名字");

        userService.save(user);
    }




}
