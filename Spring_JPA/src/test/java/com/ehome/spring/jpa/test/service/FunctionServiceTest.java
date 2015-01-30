package com.ehome.spring.jpa.test.service;

import com.ehome.spring.jpa.module.Function;
import com.ehome.spring.jpa.service.IFunctionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoxiaolei on 2015-01-28 17:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class FunctionServiceTest {

    @Resource
    private IFunctionService funService;

    @Test
    public void save() {
        Function function = new Function();
        function.setName("测试功能");
        function.setEname("testFunc");
        function.setDescription("描述... ");

        funService.save(function);
    }

    @Test
    public void update() {
        Function function = funService.findById(35L);
        if (function != null) {
            function.setName("测试功能_修改213");
            //function.setEname("testFunc_修改");
            //function.setDescription("描述... 修改");

            funService.update(function);
        }
    }



}
