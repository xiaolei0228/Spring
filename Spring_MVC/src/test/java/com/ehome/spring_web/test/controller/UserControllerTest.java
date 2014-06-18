package com.ehome.spring_web.test.controller;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
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
    public void simpleParam() {
        url += "/user/simpleParam.json";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", 888);
        paramMap.put("name", "wangwu");
        response = HttpRequest.post(url).form(paramMap).send();
    }

    @Test
    public void pathVariable() {
        url += "/user/pathVariable/123/danche";
        response = HttpRequest.post(url).send();
    }

    @Test
    public void processFormSubmit() {
        url += "/user/processFormSubmit.json";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", 888);
        paramMap.put("name", "单车上的理想");
        paramMap.put("password", 123456789);
        paramMap.put("enable", true);
        response = HttpRequest.post(url).form(paramMap).send();
    }

    @Test
    public void httpServletRequestMethod() {
        url += "/user/httpServletRequest.json?p=lihaha";
        response = HttpRequest.post(url).send();
    }

    @Test
    public void requestParam() {
        url += "/user/requestParam.json?p=lihaha";
        response = HttpRequest.post(url).form("a", "zhangsan").send();
    }


}
