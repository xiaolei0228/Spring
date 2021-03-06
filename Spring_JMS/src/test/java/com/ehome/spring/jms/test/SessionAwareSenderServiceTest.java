package com.ehome.spring.jms.test;

import com.ehome.spring.jms.entity.User;
import com.ehome.spring.jms.service.SenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import java.util.Date;

/**
 * Spring
 *
 * @作者: haoxiaolei
 * @日期: 2016-04-06 11:34
 * @描述: 发送者服务测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class SessionAwareSenderServiceTest {

    @Resource
    private SenderService senderService;
    @Resource(name = "convertOfficeQueue")
    private Destination destination;

    @Test
    public void sendQueueMessage() throws JMSException {
        senderService.sendMessage(destination, "发送一个消息：" + new Date().toLocaleString());
    }

    @Test
    public void sendQueueMessageWithSerializable() throws JMSException {
        User user = new User();
        user.setName("单车上的理想");
        user.setPassword("888888");
        user.setPid("410102218");
        senderService.sendMessage(destination, user);
    }

}
