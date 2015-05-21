package com.ehome.spring.ws.wsservice;

import com.ehome.spring.ws.bean.Price;

import javax.jws.WebService;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-05-21 15:08
 * @desc:
 */
@WebService
public interface HelloWS {
    String sayHi(String text);

    String getPriceList();
}
