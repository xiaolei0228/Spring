package com.ehome.spring.hibernate.test.service;

import com.ehome.spring.hibernate.module.Function;
import com.ehome.spring.hibernate.service.IBaseService;
import com.ehome.spring.hibernate.service.IFunctionService;
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
    private IFunctionService funcService;

    @Test
    public void save() {
        Function function = new Function();
        function.setName("添加");
        function.setEname("addFunc");
        function.setDescription("描述...添加");

        funcService.save(function);
    }

    @Test
    public void saveInBatch() {
        List<Function> functionList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Function function = new Function();
            function.setName("测试功能_" + i);
            function.setEname("testFunc_" + i);
            function.setDescription("描述... " + i);
            functionList.add(function);
        }

        List<Function> functions = (List<Function>) funcService.save(functionList);
    }

    @Test
    public void update() {
        //Function function = funcService.findById(Function.class, 9L);
        Function function = new Function();
        function.setId(8L);
        function.setName("测试功能_修改");

        funcService.update(function);
    }

    @Test
    public void updateInBatch() {
        //List<Function> functionList = new ArrayList<>();
        //for (int i = 1; i <= 10; i++) {
        //    Function function = new Function();
        //    function.setName("测试功能_" + i);
        //    function.setEname("testFunc_" + i);
        //    function.setDescription("描述... " + i);
        //    functionList.add(function);
        //}
    }

    @Test
    public void delete() {
        Function function = new Function();
        function.setId(5L);
        //funcService.delete(function);
    }

    @Test
    public void findById() {
        Function function = funcService.findById(Function.class, 11L);
        System.out.println(function.getName());
    }


}
