package com.example.demo.entity;

public class AddressBean {

    private int code;
    private String address;
    private String addressCode;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public AddressBean setCodeReturn(int code) {
        this.code = code;return this;
    }

    public AddressBean setAddressReturn(String address) {
        this.address = address;return this;
    }

    public AddressBean setAddressCodeReturn(String addressCode) {
        this.addressCode = addressCode;return this;
    }
}