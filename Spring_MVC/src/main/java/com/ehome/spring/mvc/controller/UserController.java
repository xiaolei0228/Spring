package com.ehome.spring.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ehome.spring.mvc.module.User;
import com.ehome.spring.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Project: Spring
 * @Title: spring-mvc controller层方法使用
 * @Package com.ehome.spring_web.controller
 * @Author xiaolei-0228@163.com
 * @Date 2014/6/14 0014 23:57
 * @Copyright: 2014 ihome.com
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("hello")
    public String hello(Model model) {
        User user = new User();
        user.setName("单车上的理想");

        model.addAttribute("user", user);
        return "hello";
    }

    /**
     * 简单参数，前端form里也得有对应的参数名称
     */
    @RequestMapping("/simpleParam")
    @ResponseBody
    public User simpleParam(Long id, String name) {
        System.out.println("id: " + id + "---name: " + name);
        User user = userService.getUserById(1L);
        return user;
    }

    /**
     * 通过@PathVariabl注解获取路径中传递参数
     */
    @RequestMapping("/pathVariable/{id}/{name}")
    public ModelAndView pathVariable(@PathVariable String id, @PathVariable String name) {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        return new ModelAndView("/index");
    }

    /**
     * 前端form表单直接可以对应这里的参数对象，如：user对象
     * 直接绑定数据对象模型
     * @param user 对象模型，前端可直接组装json对象扔过来,也可对应页面上的一个form表单,字段要对应
     */
    @RequestMapping(value = "/processFormSubmit", method = RequestMethod.POST)
    public String processFormSubmit(User user) {
        System.out.println(user.getId() + "---" + user.getName() + "---" + user.getPassword() + "---" + user.getEnable());
        return "success";
    }

    /**
     * 直接用HttpServletRequest获取
     */
    @RequestMapping("/httpServletRequest")
    @ResponseBody
    public String httpServletRequestMethod(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("request获取的参数: " + request.getParameter("p"));
        return "success";
    }

    /**
     * 用注解@RequestParam绑定请求参数a到变量a,也就是告诉方法，参数a是前端传过来的参数值
     * 当请求参数a不存在时会有异常发生,可以通过设置属性required=false解决,
     * 例如: @RequestParam(value="a", required=false)
     */
    @RequestMapping(value = "/requestParam", method = RequestMethod.POST)
    @ResponseBody
    public String requestParam(@RequestParam(value = "a", required = false) String a, ModelMap model) {
        System.out.println(a);
        return "helloWorld";
    }

    /**
     * 用@RequestParam绑定前端传过来的map参数
     * @param parameterMap
     */
    @RequestMapping(value = "/mapParameters")
    @ResponseBody
    public String mapParameters(@RequestParam Map<String, Object> parameterMap) {
        Map pMap;
        String paramJsonStr = parameterMap.toString();
        if (paramJsonStr.lastIndexOf("=}") != -1) { // 处理复杂json参数对象
            paramJsonStr = paramJsonStr.substring(1, paramJsonStr.length() - 2);
            System.out.println(paramJsonStr);
            pMap = JSON.parseObject(paramJsonStr, Map.class);
        } else {    // 简单json参数对象不用做处理
            pMap = parameterMap;
        }
        System.out.println(pMap);
        return "success";
    }

    /**
     * 用@RequestBody绑定前端传过来的list参数, 注意：前端json数据要用JSON.stringify(list)转一下才能传过来
     * @param parameterList
     */
    @RequestMapping(value = "/listParameters")
    @ResponseBody
    public String listParameters(@RequestBody List<Map<String,Object>> parameterList) {
        System.out.println(parameterList);
        List userList = JSON.parseObject(JSON.toJSONString(parameterList), List.class);
        for (Object obj : userList) {
            User user = JSON.parseObject(JSON.toJSONString(obj), User.class);
            System.out.println(user.getName());
        }
        return "success";
    }

    /**
     * 在方法上绑定请求体
     *
     * @param body 是一串参数，如：name=xiaohong&age=29&password=123
     */
    @RequestMapping("/getRequestBody")
    @ResponseBody
    public String getRequestBody(@RequestBody String body) {
        System.out.println(body);
        String jsonString = JSONObject.toJSONString(body);
        System.out.println(jsonString);
        return "success";
    }





















































































}
