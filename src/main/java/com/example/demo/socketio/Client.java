package com.example.demo.socketio;

import io.socket.client.IO;
import io.socket.client.Socket;

import java.util.Arrays;

/**
 * Description <P> TODO : socket.io client端 <P>
 *
 * @author DASNNJ <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-04-27 18:32
 */
public class Client {

    public static void main(String[] args) {
        init();
    }

    public static void init(){
//        String url = "http://144.202.16.97:9999";
        String url = "http://192.168.1.5:9999";
        try {
            IO.Options options = new IO.Options();
            options.transports = new String[]{"websocket"};
            //失败重试次数
            options.reconnectionAttempts = 10;
            //失败重连的时间间隔
            options.reconnectionDelay = 1000;
            //连接超时时间(ms)
            options.timeout = 5000;
            final Socket socket = IO.socket(url, options);
            socket.on("action", objects -> System.out.println("client: 收到msg" + Arrays.toString(objects)));
            //监听自定义msg事件
            socket.on("msg", objects -> System.out.println("client: 收到msg->" + Arrays.toString(objects)));
            //监听自定义订阅事件
            socket.on("sub", objects -> System.out.println("client: " + "订阅成功，收到反馈->" + Arrays.toString(objects)));
            socket.on(Socket.EVENT_CONNECT, objects -> {
                socket.emit("sub", "我是訂閲對象");
                System.out.println("client: " + "连接成功");
            });
            socket.on(Socket.EVENT_CONNECTING, objects -> System.out.println("client: " + "连接中"));
            socket.on(Socket.EVENT_CONNECT_TIMEOUT, objects -> System.out.println("client: " + "连接超时"));
            socket.on(Socket.EVENT_CONNECT_ERROR, objects -> System.out.println("client: " + "连接失败"));
            socket.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

