package com.example.demo;

import com.example.demo.socketio.Server;
import com.example.demo.utils.AddressUtils;
import com.example.demo.utils.IpUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        Server.init();
    }

}
