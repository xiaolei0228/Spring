package com.ehome.spring.websocket.controller;

import com.ehome.spring.websocket.handler.SystemWebSocketHandler;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-07-18 15:25
 * @desc: 
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    Logger logger = Logger.getLogger(AdminController.class);

    @Resource
    private SystemWebSocketHandler systemWebSocketHandler;

    @RequestMapping("/sendMsg")
    @ResponseBody
    public String sendMsg(HttpServletRequest request) {
        TextMessage message = new TextMessage("我是消息内容..." + new Date().toLocaleString());
        // 广播
        systemWebSocketHandler.broadcast(message);

        // 单播
        //systemWebSocketHandler.unicast("32DB4AB5520C9DAC658B4905202358941", message);

        return null;
    }
}
