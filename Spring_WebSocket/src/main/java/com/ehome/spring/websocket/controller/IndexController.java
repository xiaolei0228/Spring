package com.ehome.spring.websocket.controller;

import com.ehome.spring.websocket.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class IndexController {

    @RequestMapping("")
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("hello", "spring mvc");
        HttpSession session = request.getSession(true);
        String sessionId = session.getId() + new Date().getTime();  // 重新组装唯一sessionId
        session.setAttribute(Constant.SESSION_ID, sessionId);
        System.out.println("==================sessionId: " + sessionId);

        return "index";
    }
}
