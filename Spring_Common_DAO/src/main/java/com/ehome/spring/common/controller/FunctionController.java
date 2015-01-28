package com.ehome.spring.common.controller;

import com.ehome.spring.common.module.Function;
import com.ehome.spring.common.service.IFunctionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
        //Function savedFunc = functionService.save(function);
        List<Function> functionList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Function fun = new Function();
            fun.setName("测试功能_" + i);
            fun.setEname("testFunc_" + i);
            fun.setDescription("描述... " + i);
            functionList.add(fun);
        }

        return functionService.save(functionList);
    }


}
