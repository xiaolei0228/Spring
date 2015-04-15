package com.ehome.spring.jms.service;

import javax.jms.JMSException;
import javax.jms.Message;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-04-15 10:43
 * @desc:
 */
public interface JmsService {

    void sendMessage(Message message);

    void receiveMessage() throws JMSException;
}
