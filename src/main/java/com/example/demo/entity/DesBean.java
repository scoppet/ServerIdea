package com.example.demo.entity;

public class DesBean {

    private String password;

    private String info;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DesBean(String password, String info) {
        this.password = password;
        this.info = info;
    }
}
