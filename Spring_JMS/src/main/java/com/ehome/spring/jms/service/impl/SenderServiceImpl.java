package com.ehome.spring.jms.service.impl;

import com.ehome.spring.jms.service.SenderService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.SessionCallback;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import java.io.Serializable;

/**
 * Spring
 *
 * @作者: haoxiaolei
 * @日期: 2016-04-06 15:18
 * @描述: 队列发送服务
 */
@Service
public class SenderServiceImpl implements SenderService {

    @Resource
    private JmsTemplate jmsTemplate;

    /**
     * 发送普通的纯文本消息
     *
     * @param destination 目标
     * @param message     文件消息
     */
    public void sendMessage(Destination destination, String message) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

    /**
     * 发送一个ObjectMessage
     *
     * @param destination 目标
     * @param obj         可序列化的对象
     */
    public void sendMessage(Destination destination, final Serializable obj) {
        jmsTemplate.execute(new SessionCallback<Object>() {
            public Object doInJms(Session session) throws JMSException {
                MessageProducer producer = session.createProducer(destination);
                Message message = session.createObjectMessage(obj);
                producer.send(message);
                return message;
            }
        });
    }
}
