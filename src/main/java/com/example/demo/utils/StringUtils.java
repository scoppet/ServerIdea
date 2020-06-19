package com.example.demo.utils;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class StringUtils {

    public static Boolean isNotEmpty(String str){
        if(!org.springframework.util.StringUtils.isEmpty(str)){
            return true;
        }
        return false;
    }

    public static String removeDoubleQuote(String str){
        return str.substring(1,str.length()-1);
    }

}
