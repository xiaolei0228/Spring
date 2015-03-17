package com.ehome.spring.hibernate.test.service;

import com.ehome.spring.hibernate.module.Function;
import com.ehome.spring.hibernate.service.IFunctionService;
import com.ehome.spring.hibernate.util.Pager;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
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
        Function function = funcService.findById(Function.class, 7L);
        //Function function = new Function();
        //function.setId(7L);
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
        function.setId(7L);
        funcService.delete(function);
    }

    @Test
    public void deleteById() {
        funcService.delete(Function.class, 11L);
    }

    @Test
    public void deleteByCriteria() {
        DetachedCriteria dc = DetachedCriteria.forClass(Function.class);
        dc.add(Restrictions.isNull("ename"));
        List<Function> functionList = funcService.delete(Function.class, dc);
        for (Function function : functionList) {
            System.out.println(function.getName());
        }
    }

    @Test
    public void find() {
        List<Function> funList = funcService.find(Function.class, "name", "测试功能_3");
        for (Function fun : funList) {
            System.out.println(fun.getEname() + "---" + fun.getDescription());
        }
    }

    @Test
    public void findById() {
        Function function = funcService.findById(Function.class, 11L);
        System.out.println(function.getName());
    }

    @Test
    public void findByIdList() {
        List<Long> idList = new ArrayList<>();
        idList.add(1L);
        idList.add(2L);
        List<Function> functionList = funcService.findByIds(Function.class, idList);
        for (Function function : functionList) {
            System.out.println(function.getName());
        }
    }

    @Test
    public void findList() {
        DetachedCriteria dc = DetachedCriteria.forClass(Function.class);
        dc.add(Restrictions.like("name", "%2%"));
        dc.add(Restrictions.in("id", new Object[]{1L, 2L, 3L, 4L}));
        List<Function> functionList = funcService.findList(Function.class, dc);
        System.out.println(functionList.size());
    }

    @Test
    public void findListPager() {
        DetachedCriteria dc = DetachedCriteria.forClass(Function.class);
        dc.add(Restrictions.like("name", "%修改%"));
        Pager pager = new Pager();
        pager.setPageSize(2);
        List<Function> functionList = funcService.findList(Function.class, dc, pager);
        System.out.println("返回行数：" + functionList.size());
        System.out.println("总页面数：" + pager.getTotalPage());
        System.out.println("总行数：" + pager.getTotalRow());
    }

    @Test
    public void findAll() {
        List<Function> functionList = funcService.findAll(Function.class);
        System.out.println(functionList.size());
    }


}
