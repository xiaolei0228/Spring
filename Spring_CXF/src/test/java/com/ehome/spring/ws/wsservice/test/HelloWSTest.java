package com.ehome.spring.ws.wsservice.test;

import com.ehome.spring.ws.wsservice.HelloWS;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-05-21 15:51
 * @desc: 
 */
public class HelloWSTest {

    @Test
    public void invokeWS() {
        //调用WebService
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloWS.class);
        factory.setAddress("http://localhost/ws/hello");

        HelloWS service = (HelloWS) factory.create();
        String result = service.sayHi("单车上的理想");
        System.out.println(result);
    }

    @Test
    public void getPriceList() {
        //调用WebService
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloWS.class);
        factory.setAddress("http://localhost/ws/hello");

        HelloWS service = (HelloWS) factory.create();
        String result = service.getPriceList();
        System.out.println(result);
    }
}
