package com.zkt.service.Impl;

import co.zkt.entity.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zkt.api.service.ChatService;
import com.zkt.dao.ChatMapper;
import com.zkt.entitys.Userinfo;
import com.zkt.manage.ChatManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.client.WebSocketClient;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/chat/{userId}")
@Controller
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatMapper chatManage;

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<ChatServiceImpl> wsClientMap = new CopyOnWriteArraySet<ChatServiceImpl>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     * @param session
     */
    @OnOpen
    public void onOpen (@PathParam("userId")String userId,Session session){
        this.session = session;
        wsClientMap.add(this);
        addOnlineCount();
        //logger.info(session.getId()+"有新链接加入，当前链接数为：" + wsClientMap.size());
    }

    /**
     * 连接关闭
     */

    @OnClose
    public void onClose(){
        wsClientMap.remove(this);
        subOnlineCount();
    }

    /**
     * * 收到客户端消息
     * * @param message 客户端发送过来的消息
     * @param session 当前会话session
     * @throws IOException
     * * @throws EncodeException 
     */
    @OnMessage
    public void onMessage (String message, Session session,@PathParam("userId")String userId) throws IOException, EncodeException {
        //logger.info("来终端的警情消息:" + message);
        sendMsgToAll(userId,message);
        System.out.println("客户端发送过来的消息:"+message);
    }


    /**
     * 发生错误
     */
    @OnError
    public void onError(Session session, Throwable error) {
        //logger.info("wsClientMap发生错误!");
        error.printStackTrace();
    }

    // 把map转化成json的string格式
    public String encode(Map<String, Object> map) throws EncodeException {
        ObjectMapper mapMapper= new ObjectMapper();
        try {
            String json="";
            json = mapMapper.writeValueAsString(map);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }
    /**
     * 给所有客户端群发消息
     * @param message 消息内容
     * @throws IOException
     * @throws EncodeException 
     */
    public void sendMsgToAll(String userId,String message) throws IOException, EncodeException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("message", message);
        for ( ChatServiceImpl item : wsClientMap ){
            item.session.getBasicRemote().sendText(encode(map));
        }
//logger.info("成功群送一条消息:" + wsClientMap.size());
    }
    //    public void sendMessage (String message) throws IOException {

//        this.session.getBasicRemote().sendText(message);  

//        logger.info("成功发送一条消息:" + message);

//    }

    public static synchronized int getOnlineCount (){
        return ChatServiceImpl.onlineCount;
    }


    public static synchronized void addOnlineCount (){
        ChatServiceImpl.onlineCount++;
    }


    public static synchronized void subOnlineCount (){
        ChatServiceImpl.onlineCount--;
    }


}
