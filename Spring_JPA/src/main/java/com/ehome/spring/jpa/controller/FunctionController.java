package com.ehome.spring.jpa.controller;

import com.ehome.spring.jpa.module.Function;
import com.ehome.spring.jpa.service.IFunctionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by xiaolei on 2015-01-17 23:23
 */

@Controller
@RequestMapping("/func")
public class FunctionController {

    @Resource
    private IFunctionService functionService;


    @RequestMapping("save")
    @ResponseBody
    public Object save(Function function) {
        Function savedFunc = functionService.save(function);

        return savedFunc;
    }
}
