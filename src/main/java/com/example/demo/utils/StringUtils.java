package com.example.demo.utils;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class StringUtils {

    public static Boolean isNotEmpty(String str){
        if(!org.springframework.util.StringUtils.isEmpty(str)){
            return true;
        }
        return false;
    }

}
