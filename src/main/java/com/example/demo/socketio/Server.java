package com.example.demo.socketio;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

import java.util.Map;

/**
 * Description <P> TODO : socket.io server端 <P>
 *
 * @author DASNNJ <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-04-27 18:31
 */

public class Server {
    public static void main(String[] args) {
        init();
    }

    public static void init(){
        Configuration config = new Configuration();
//        config.setHostname("144.202.16.97");
        config.setHostname("192.168.1.5");
        config.setPort(9999);
        SocketIOServer server = new SocketIOServer(config);
        server.addConnectListener(client -> {
            System.out.println("server: " + client.getRemoteAddress() + "客户端连接成功");
        });
        //添加action事件
        server.addEventListener("action", String.class,((client, s, ackRequest) -> {
            server.getBroadcastOperations().sendEvent("action","sss");
        }));
        //添加sub事件
        server.addEventListener("sub", String.class, (client, data, ackRequest) -> {
            String c= client.getRemoteAddress().toString();
            //获取客户端url参数
            Map params = client.getHandshakeData().getUrlParams();
            System.out.println("server: " + c+ "：客户端：订阅成功，订阅信息為->" + data);
            //sub事件成功反馈
            client.sendEvent("sub", c+ "客户端你好，我是服务端，你订阅成功了");
        });

        //添加客户端断开连接事件
        server.addDisconnectListener(client -> {
            String c= client.getRemoteAddress().toString();
            //获取设备ip
            String clientIp = c.substring(1, c.indexOf(":"));
            System.out.println("server: " + clientIp + "-------------------------" + "客户端已断开连接");
        });
        server.start();

//        int i = 0;
//        while (true) {
//            try {
//                Thread.sleep(1500);
//                //广播消息
//                i++;
//                server.getBroadcastOperations().sendEvent("msg", "30", "hello" + i, "true");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }
}