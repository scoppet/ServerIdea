package com.example.demo.controller;


import com.example.demo.entity.Data;
import com.example.demo.entity.Info;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "register")
public class RegisterController {

    @GetMapping(value = "reg")
    public Data get(Info info){
        return new Data();
    }

    @PostMapping(value = "reg")
    public Data post(Info info){
        return new Data();
    }

    public Data doRegister(){
        return new Data();
    }


}
