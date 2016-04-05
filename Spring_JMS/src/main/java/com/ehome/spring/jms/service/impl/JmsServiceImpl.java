package com.ehome.spring.jms.service.impl;

import com.ehome.spring.jms.service.JmsService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-04-15 10:11
 * @desc:
 */
@Service("jmsService")
public class JmsServiceImpl implements JmsService {

    @Resource
    private JmsTemplate jmsTemplate;
    @Resource
    private Destination destination;

    /**
     * 发送消息
     */
    public void sendMessage(final Message message) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(((TextMessage) message).getText());
            }
        });
    }

    /**
     * 接收消息
     */
    public void receiveMessage() throws JMSException {
        TextMessage message = (TextMessage) jmsTemplate.receive();
        System.out.println(message.getText());
        receiveMessage();
    }

}
