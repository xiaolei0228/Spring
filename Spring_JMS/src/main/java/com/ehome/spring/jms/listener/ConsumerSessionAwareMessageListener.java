package com.ehome.spring.jms.listener;

import com.ehome.spring.jms.entity.User;
import com.ehome.spring.jms.service.ISenderService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Spring
 *
 * @author: haoxiaolei
 * @date: 2016-04-06 14:51
 * @desc:
 */
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener {

    @Resource
    private ISenderService senderService;

    public void onMessage(Message message, Session session) throws JMSException {
        if (message instanceof TextMessage) {
            TextMessage msg = (TextMessage) message;
            System.out.println("收到一条消息内容是：" + msg.getText());
        } else if (message instanceof ObjectMessage) {
            ObjectMessage objMsg = (ObjectMessage) message;
            User user = (User) objMsg.getObject();
            System.out.println(user.getName() + "\t" + user.getPassword());
            String pid = user.getPid();
            // 写service方法处理业务逻辑
            String queue = "point_" + pid + "_queue";
            Destination destination = new ActiveMQQueue(queue);
            senderService.sendMessage(destination, "业务处理完返回给pc端消息结果...");
        }
    }
}
