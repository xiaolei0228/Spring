package com.ehome.spring.jms.service;

import javax.jms.Destination;
import java.io.Serializable;

/**
 * Spring
 * @作者: haoxiaolei
 * @日期: 2016-04-06 15:17
 * @描述: 队列发送者服务
 */
public interface SenderService {

    /**
     * 发送普通的纯文本消息
     * @param destination 目标
     * @param message     文件消息
     */
    void sendMessage(Destination destination, String message);

    /**
     * 发送一个ObjectMessage
     * @param destination 目标
     * @param obj         可序列化的对象
     */
    void sendMessage(Destination destination, Serializable obj);
}
