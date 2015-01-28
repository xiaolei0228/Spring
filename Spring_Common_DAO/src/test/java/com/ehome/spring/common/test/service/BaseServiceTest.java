package com.ehome.spring.common.test.service;

import com.ehome.spring.common.module.Function;
import com.ehome.spring.common.service.IBaseService;
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
public class BaseServiceTest {

    @Resource
    private IBaseService baseService;

    @Test
    public void save() {
        List<Function> functionList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Function function = new Function();
            function.setName("测试功能_" + i);
            function.setEname("testFunc_" + i);
            function.setDescription("描述... " + i);
            functionList.add(function);
        }

        baseService.save(functionList);
    }

}
