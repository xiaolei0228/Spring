package com.ehome.spring.hibernate.test.service;

import com.ehome.spring.hibernate.module.User;
import com.ehome.spring.hibernate.service.IUserService;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-04-22 10:49
 * @desc: 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserServiceTest {
    private static Logger logger = Logger.getLogger(UserServiceTest.class);

    @Resource
    IUserService userService;

    @Test
    public void save() {
        User user = new User();
        user.setName("test");
        user.setMobile("123456789");
        user.setAge(29);
        user.setAddress("郑州市");
        userService.save(user);
    }

    @Test
    public void findById() {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        criteria.add(Restrictions.eq("name", "test"));
        List<User> userList = userService.findList(User.class, criteria);
        for (User user : userList) {
            logger.info(user.getName() + "---" + user.getMobile() + "---" + user.getAddress());
        }
    }

    @Test
    public void findList() {
        List<User> userList = userService.findAll(User.class);
        for (User user : userList) {
            logger.info(user.getName() + "---" + user.getMobile() + "---" + user.getAddress());
        }
    }
}
