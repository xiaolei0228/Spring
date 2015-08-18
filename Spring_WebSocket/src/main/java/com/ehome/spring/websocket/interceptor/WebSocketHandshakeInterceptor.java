package com.ehome.spring.websocket.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

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
     * 在握手之前要做的事情
     * @param req
     * @param resp
     * @param wsHandler
     * @param attributes
     */
    public boolean beforeHandshake(ServerHttpRequest req, ServerHttpResponse resp, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        System.out.println("Before Handshake...");
        return super.beforeHandshake(req, resp, wsHandler, attributes);
    }

    /**
     * 握手之后要做的事情
     * @param request
     * @param response
     * @param wsHandler
     * @param ex
     */
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        System.out.println("After Handshake...");
        super.afterHandshake(request, response, wsHandler, ex);
    }

}
