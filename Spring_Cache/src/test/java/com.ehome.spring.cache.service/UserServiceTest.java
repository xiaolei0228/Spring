package com.ehome.spring.cache.service;

import com.ehome.spring.cache.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        for (int i = 1; i <= 10; i++) {
            User u = new User();
            u.setName("test_" + i);
            //u.setMobile("100" + i);
            //u.setSex(2);
            User user = userService.save(u);
            System.out.println(user.getId());
        }
    }

    @Test
    public void update() {
        Map<String, Object> updateColumn = new HashMap<>();
        updateColumn.put("mobile", "110");
        Map<String, Object> where = new HashMap<>();
        where.put("name", "aa");
        where.put("sex", 0);
        userService.update(updateColumn, where);
    }


    @Test
    public void findList() {
        for (int i = 1; i <= 10; i++) {
            User u = new User();
            u.setName("test_" + i);
            //u.setMobile("100" + i);
            //u.setSex(2);
            User user = userService.save(u);
            System.out.println(user.getId());
        }

        List<User> userList = userService.findList();
        for (User user : userList) {
            System.out.println(user.getName());
        }
    }

}
