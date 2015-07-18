package com.ehome.spring.websocket.handler;

import org.apache.log4j.Logger;
import org.springframework.core.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-07-18 11:38
 * @desc: 系统级别的webSocket的处理类
 */
@Component
public class SystemWebSocketHandler implements WebSocketHandler {
    private static final Logger logger;

    private final static Map<String, WebSocketSession> sessionMap;
    private final static List<String> sessionIdList;

    static {
        logger = Logger.getLogger(SystemWebSocketHandler.class);
        sessionMap = new HashMap<>();
        sessionIdList = new ArrayList<>();
    }

    /**
     * 建立连接之后
     *
     * @param webSocketSession
     *
     * @throws Exception
     */
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        logger.debug("websocket连接建立成功......");
        /**
         * 获取在握手之前放到attributes里的唯一标识值，再加上真正的websocketId值，组成一个最终的唯一的key，并与websocketSession一起放到sessionMap里。
         * 在sessionMap里可以全部遍历实现广播，也可以get(key)获取单个的实现单播。
         */
        Map<String, Object> attributes = webSocketSession.getAttributes();
        String sessionId = attributes.get("sessionId") != null ? attributes.get("sessionId").toString() : "";
        sessionId += webSocketSession.getId();
        sessionIdList.add(sessionId);

        sessionMap.put(sessionId, webSocketSession);
        webSocketSession.sendMessage(new TextMessage("hello~欢迎加入ehome"));
    }

    /**
     * 传输消息的时候
     *
     * @param webSocketSession
     * @param webSocketMessage
     *
     * @throws Exception
     */
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {

    }

    /**
     * 传输错误的时候
     *
     * @param webSocketSession
     * @param throwable
     *
     * @throws Exception
     */
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if (webSocketSession.isOpen()) webSocketSession.close();
        logger.debug("websocket连接关闭!");
        sessionMap.remove(webSocketSession.getId());
    }

    /**
     * 连接关闭之后
     *
     * @param webSocketSession
     * @param closeStatus
     *
     * @throws Exception
     */
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        logger.debug("websocket连接关闭!");
        sessionMap.remove(webSocketSession.getId());
    }

    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 广播
     *
     * @param message 消息对象
     */
    public void broadcast(WebSocketMessage message) {
        for (Map.Entry<String, WebSocketSession> map : sessionMap.entrySet()) {
            WebSocketSession webSocketSession = map.getValue();
            if (webSocketSession.isOpen()) {
                try {
                    webSocketSession.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 单播
     *
     * @param sessionId 经过改装的会话Id
     * @param message   消息对象
     */
    public void unicast(String sessionId, WebSocketMessage message) {
        WebSocketSession webSocketSession = sessionMap.get(sessionId);
        if (webSocketSession != null && webSocketSession.isOpen()) {
            try {
                webSocketSession.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
