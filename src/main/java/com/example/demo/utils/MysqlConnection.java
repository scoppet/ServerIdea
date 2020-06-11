package com.example.demo.utils;

import com.example.demo.entity.Info;
import com.example.demo.entity.Login;
import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.rmi.runtime.Log;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysqlConnection {

    public static void main(String[] args) {
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_user?serverTimezone=UTC","root","toor");
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public static Map<String,String> getAllUser(){
        Map<String, String> map = new HashMap<>();
        try {
            Connection connection = getConnection();

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while (rs.next()){
                map.put(rs.getString("username"), rs.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    public static String login(Login info){
        Map<String, String> map = new HashMap<>();
        try {
            Connection connection = getConnection();

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while (rs.next()){
                map.put(rs.getString("username"), rs.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(map.containsKey(info.getUsername())){
            if(map.get(info.getUsername()).equals(info.getPassword())){
                return "1";
            }else {
                return "2";
            }
        }
        return "3";
    }

    public static Boolean registerUser(Login login){
        Boolean flag = false;
        try {
            Connection connection = getConnection();

            PreparedStatement psmt = connection.prepareStatement("insert into user values (?, ?)");
            psmt.setString(1, login.getUsername());
            psmt.setString(2, login.getPassword());


            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while (rs.next()){
                if(rs.getString("username").equals(login.getUsername())){
                    flag = true;
                }
            }
            if(!flag){
                psmt.executeUpdate();
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
