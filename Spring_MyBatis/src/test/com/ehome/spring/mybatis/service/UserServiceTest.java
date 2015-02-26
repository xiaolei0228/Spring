package ehome.spring.mybatis.service;

import com.ehome.spring.mybatis.module.User;
import com.ehome.spring.mybatis.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by haoxiaolei on 2015-02-26 11:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserServiceTest {

    @Resource
    private IUserService userService;

    @Test
    public void save() {
        User u = new User();
        u.setName("xiaolei");
        u.setAge(28);
        u.setBirthday(new Date(478368000000L));
        u.setAddress("林州市");

        userService.save(u);
    }
}
