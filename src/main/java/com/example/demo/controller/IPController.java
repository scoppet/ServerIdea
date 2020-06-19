package com.example.demo.controller;

import com.example.demo.entity.Data;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;

@RestController
@RequestMapping(value = "/ip")
public class IPController {

    @GetMapping (value = "localip")
    public Data getLocalIP(){
        return getIp();
    }

    private Data getIp(){
        String result = "unknown ip";

        return new Data().setCode(0).setResult(result);
    }


}
