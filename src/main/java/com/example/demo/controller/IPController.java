package com.example.demo.controller;

import com.example.demo.entity.Data;
import com.example.demo.utils.IpUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
