package com.it.lawhelp.spring.controller;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
@Component
@ServerEndpoint("/websocket")
public class WebSocketTest {
    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<WebSocketTest> webSocketSet =new CopyOnWriteArraySet<WebSocketTest>();
    private Session session;
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }
    @OnMessage
    public void onMessage(String message,Session session){
        for(WebSocketTest item:webSocketSet){
            try{
                item.sendMessage(message);
            }catch (IOException e){
                e.printStackTrace();
                continue;
            }
        }
    }
    @OnError
    public void onErroe(Session session,Throwable error){
        System.out.println("发送错误");
        error.printStackTrace();
    }
    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }
    public static synchronized int getOnlineCount() {
         return onlineCount;
    }
    public static synchronized void addOnlineCount() {
        WebSocketTest.onlineCount++;
    }
    public static synchronized void subOnlineCount() {
        WebSocketTest.onlineCount--;
    }
}
