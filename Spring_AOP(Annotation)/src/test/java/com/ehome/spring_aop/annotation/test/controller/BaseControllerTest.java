package com.ehome.spring_aop.annotation.test.controller;

import com.alibaba.fastjson.JSONObject;
import jodd.http.HttpResponse;
import org.junit.After;
import org.junit.Before;

/**
 * @version V1.0
 * @Project: Spring
 * @Title: 测试webapi的基础类
 * @Package com.ehome.spring_web.test.controller
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/6/16 0016 22:35
 * @Copyright: 2014 ihome.com
 */
public class BaseControllerTest {
    protected String url = "http://127.0.0.1/springaop/api";
    protected HttpResponse response = null;
    protected JSONObject paramJson;

    @Before
    public void init() {
        paramJson = new JSONObject();
    }

    @After
    public void end() {
        response.charset("UTF-8");
        System.out.println("返回的数据:" + response.bodyText());
    }
}
