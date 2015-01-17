package com.ehome.spring.jpa.test.controller;

import jodd.http.HttpRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能测试
 */
public class FunctionControllerTest extends BaseControllerTest {

    @Test
    public void saveFunction() {
        url += "/func/save";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", "更新");
        paramMap.put("ename", "update");
        paramMap.put("description", "更新功能");
        response = HttpRequest.post(url).form(paramMap).send();
    }

    @Test
    public void findList() {
        url += "/func/findList";
        response = HttpRequest.post(url).send();
    }

























}
