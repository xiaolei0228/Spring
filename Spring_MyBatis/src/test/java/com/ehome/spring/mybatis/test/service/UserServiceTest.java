package com.ehome.spring.mybatis.test.service;

import com.ehome.spring.mybatis.service.IUserService;
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



}
