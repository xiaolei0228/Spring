package com.ehome.spring.websocket.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-07-18 11:45
 * @desc: handshake(握手)拦截器
 */
public class WebSocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    /**
     * 在握手之前要做的事情，在这里可以与数据库交互，取得能标识当前socket是唯一的即可。<br/>
     * 如获取当前session中的用户名，用户Id 等等，把下面的sessionId替换成这个唯一标识
     * (目前的是用sessionId来模拟的)
     * @param req
     * @param resp
     * @param wsHandler
     * @param attributes
     */
    public boolean beforeHandshake(ServerHttpRequest req, ServerHttpResponse resp, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        System.out.println("Before Handshake...");
        ServletServerHttpRequest request = (ServletServerHttpRequest) req;
        String sessionId = request.getServletRequest().getSession(true).getId();
        attributes.put("sessionId", sessionId);
        return super.beforeHandshake(req, resp, wsHandler, attributes);
    }

    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        System.out.println("After Handshake...");
        super.afterHandshake(request, response, wsHandler, ex);
    }

}
