package com.ehome.spring_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 郝晓雷 on 2015/3/30 0030.
 */
@Controller
@RequestMapping()
public class IndexController {

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("hello", "spring mvc");
        return "index";
    }
}
