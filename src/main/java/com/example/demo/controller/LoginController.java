package com.example.demo.controller;

import com.example.demo.entity.Data;
import com.example.demo.entity.Login;
import com.example.demo.utils.MysqlConnection;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @GetMapping(value = "/login")
    public Data get(Login login){
        return getLoginResult(login);
    }

    @GetMapping(value = "/register")
    public Data post(Login login){
        return doRegister(login);
    }

    @GetMapping(value = "/alluser")
    public Data user(){
        return getAllUser();
    }

    private Data getLoginResult(Login login){
        String result = "";
        String code = MysqlConnection.login(login);
        switch (code){
            case "1":
                result = "login success";
                break;
            case "3":
                result = "wrong username";
                break;
            case "2":
                result = "wrong password";
                break;
        }
        return new Data().setCode(0).setResult(result);
    }

    private Data getAllUser(){
        Map<String,String> map = MysqlConnection.getAllUser();
        String result = map.toString();
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (String key : map.keySet()) {
            builder.append("{"+key+":"+map.get(key)+"},");
        }
        String a = builder.toString();
        a = a.substring(0,a.length()-1);
        builder = new StringBuilder(a);
        builder.append("}");
        System.out.println("111");
        return new Data().setCode(0).setResult(builder.toString());
    }

    private Data doRegister(Login login){
        Boolean flag = MysqlConnection.registerUser(login);
        String result = "";
        if(flag){
            result = "successful";
        }else {
            result = "failed,username has used";
        }
        return new Data().setCode(0).setResult(result);
    }

}
