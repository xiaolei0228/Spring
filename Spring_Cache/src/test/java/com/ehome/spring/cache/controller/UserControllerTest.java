package com.ehome.spring.cache.controller;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring
 *
 * @author: haoxiaolei
 * @date: 2015-04-08 23:25
 * @desc: 
 */
public class UserControllerTest {
    protected String url = "http://127.0.0.1";

    @Test
    public void saveUser() {
        url += "/user/save";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", 888);
        paramMap.put("name", "zhaoliu");
        paramMap.put("sex", "1");
        paramMap.put("mobile", "13071011950");
        HttpResponse response = HttpRequest.post(url).form(paramMap).send();
    }

    @Test
    public void findList() {
        url += "/user/findList";
        HttpResponse response = HttpRequest.post(url).send();
    }
}
