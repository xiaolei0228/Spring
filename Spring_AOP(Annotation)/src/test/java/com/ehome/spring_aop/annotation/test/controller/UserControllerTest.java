package com.ehome.spring_aop.annotation.test.controller;

import jodd.http.HttpRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @Project: Spring
 * @Title:
 * @Package PACKAGE_NAME
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/6/16 0016 22:33
 * @Copyright: 2014 ihome.com
 */
public class UserControllerTest extends BaseControllerTest {

    @Test
    public void saveUser() {
        url += "/user/saveUser.json";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", "wangwu");
        paramMap.put("password", 888);
        response = HttpRequest.post(url).form(paramMap).send();
    }

    @Test
    public void updateUser() {
        url += "/user/updateUser.json";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", "1");
        response = HttpRequest.post(url).form(paramMap).send();
    }

























}
