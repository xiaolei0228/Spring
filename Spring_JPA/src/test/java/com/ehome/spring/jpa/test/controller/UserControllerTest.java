package com.ehome.spring.jpa.test.controller;

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
        url += "/user/save";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", "单车上的理想");
        paramMap.put("sex", "1");
        paramMap.put("mobile", "13071011950");
        response = HttpRequest.post(url).form(paramMap).send();
    }

    @Test
    public void findList() {
        url += "/user/findList";
        response = HttpRequest.post(url).send();
    }

























}
