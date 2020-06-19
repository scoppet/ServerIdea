package com.example.demo.controller;

import com.example.demo.entity.AddressBean;
import com.example.demo.entity.Data;
import com.example.demo.entity.Login;
import com.example.demo.utils.AddressUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/address")
public class AddressController {

    @GetMapping (value = "/addresscode")
    public static AddressBean getAdderssCode(String address){
        return getAddressCodeByAddress(address);
    }

    private static AddressBean getAddressCodeByAddress(String address){
        String result = AddressUtils.getAddressCodeByAddress(address);
        return new AddressBean().setCodeReturn(0).setAddressReturn(address).setAddressCodeReturn(result);
    }
}
