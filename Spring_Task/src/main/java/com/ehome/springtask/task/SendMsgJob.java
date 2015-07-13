package com.ehome.springtask.task;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-07-13 15:45
 * @desc: 测试发送消息任务
 */
@Service
public class SendMsgJob {

    public void send() {
        System.out.println("发送..." + new Date().toLocaleString());
    }
}
