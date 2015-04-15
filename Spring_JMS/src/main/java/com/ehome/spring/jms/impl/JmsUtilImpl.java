package com.ehome.spring.jms.impl;

import com.ehome.spring.jms.JmsUtil;
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
@Service("jmsUtil")
public class JmsUtilImpl implements JmsUtil {

    @Resource
    private JmsTemplate jmsTemplate;
    @Resource
    private Destination destination;

    /**
     * 发送消息
     */
    public void sendMessage(Message message) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(((TextMessage) message).getText());
            }
        });
    }

    /**
     * 接收消息
     */
    public Message receiveMessage() {
        TextMessage message = (TextMessage) jmsTemplate.receive();
        return message;
    }

}
