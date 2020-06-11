package com.example.demo.controller;

import com.example.demo.entity.Data;
import com.example.demo.entity.DesBean;
import com.example.demo.utils.DESUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/des")
public class DESController {

    @GetMapping(value = "/encrypt")
    public Data getEncrypt(DesBean des){
        return getEncryptContent(des);
    }

    @GetMapping (value = "/decrypt")
    public Data getDecrypt(DesBean des){
        return getDecryptContent(des);
    }

    private Data getEncryptContent(DesBean des){
        String result = DESUtils.encrypt(des.getPassword(), des.getInfo());
        return new Data().setCode(0).setResult(result);
    }

    private Data getDecryptContent(DesBean des){
        String result = DESUtils.decrypt(des.getPassword(), des.getInfo());
        return new Data().setCode(1).setResult(result);
    }
}
