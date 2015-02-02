package com.ehome.spring.jdbc.service;

import com.ehome.spring.jdbc.module.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2015-02-02 22:12 To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserServiceTest {

    @Resource
    private IUserService userService;

    @Test
    public void save() {
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setName("test_" + i);
            u.setMobile("100" + i);
            u.setSex(2);
            userService.save(u);
        }
    }
}
