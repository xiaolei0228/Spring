package com.ehome.spring.test;

import com.ehome.spring.ioc.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Project: Spring
 * @Title:
 * @Package PACKAGE_NAME
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/6/13 0013 23:14
 * @Copyright: 2014 ihome.com
 */
public class UserTest {
    ApplicationContext act;

    @Before
    public void init() {
        act = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void getUserById() {
        UserService userService = (UserService) act.getBean("userService");
        userService.getUserById(88L);
    }

}
