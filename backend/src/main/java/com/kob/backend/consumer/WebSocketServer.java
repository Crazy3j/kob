package com.kob.backend.consumer;


import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName WebSocketServer
 * @Description TODO
 * @Author Ultraman
 * @Date 2023/3/7 21:41
 * @Version 1.0
 */


@Component
@ServerEndpoint("/websocket/{token}")  // 注意不要以'/'结尾
public class WebSocketServer {

    private static ConcurrentHashMap<Integer, WebSocketServer> users = new ConcurrentHashMap<>();
    private User user;
    private Session session = null;
    private static UserMapper userMapper;

    @Resource
    public void setUserMapper(UserMapper userMapper) {
        WebSocketServer.userMapper = userMapper;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) {
        // 建立连接
        this.session = session;
        System.out.println("connected!");
        int userId = Integer.parseInt(token);
        this.user = userMapper.selectById(userId);
        users.put(userId, this);
    }

    @OnClose
    public void onClose() {
        // 关闭链接
        System.out.println("disconnected");
        if (this.user != null) {
            users.remove(this.user.getId());
        }


    }

    @OnMessage
    public void onMessage(String message, Session session) {
        // 从Client接收消息
        System.out.println("getMessage");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public void sendMessage(String message) {
        synchronized (this.session) {
            try {
                this.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

