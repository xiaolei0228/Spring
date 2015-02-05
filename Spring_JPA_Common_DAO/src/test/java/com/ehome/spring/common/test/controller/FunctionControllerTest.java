package com.ehome.spring.common.test.controller;

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
        paramMap.put("name", "添加");
        paramMap.put("ename", "add");
        paramMap.put("description", "添加功能");
        response = HttpRequest.post(url).form(paramMap).send();
    }

    @Test
    public void findList() {
        url += "/func/findList";
        response = HttpRequest.post(url).send();
    }




























}
