package com.ehome.spring.jms.init;

import com.ehome.spring.jms.service.JmsService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-04-15 14:55
 * @desc: 当容器启动的时候会执行onApplicationEvent
 */
@Component
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private JmsService jmsService;

    /**
     * 当容器启动的时候会执行的方法
     */
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("-------------------- 容器已启动 --------------------");
        try {
            jmsService.receiveMessage();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}