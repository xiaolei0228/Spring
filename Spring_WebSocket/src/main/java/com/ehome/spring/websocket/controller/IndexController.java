package com.ehome.spring.websocket.controller;

import com.ehome.spring.websocket.handler.SystemWebSocketHandler;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-07-18 15:25
 * @desc: 
 */
@Controller
@RequestMapping("admin")
public class IndexController {

    @RequestMapping("")
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("hello", "spring mvc");
        return "index";
    }
}
