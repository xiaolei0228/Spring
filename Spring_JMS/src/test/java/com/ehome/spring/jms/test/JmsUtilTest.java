package com.ehome.spring.jms.test;

import com.ehome.spring.jms.JmsUtil;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-04-15 10:35
 * @desc: 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class JmsUtilTest {

    @Resource
    public JmsUtil jmsUtil;

    @Test
    public void sendMessage() throws JMSException {
        TextMessage message = new ActiveMQTextMessage();
        message.setText("随便一个消息...监听中发送消息");
        jmsUtil.sendMessage(message);
    }

    @Test
    public void receiveMessage() throws JMSException {
        TextMessage message = (TextMessage) jmsUtil.receiveMessage();
        System.out.println("接收到的消息：" + message.getText());
    }
}
