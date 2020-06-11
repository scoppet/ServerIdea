package com.example.demo.controller;

import com.example.demo.entity.Data;
import com.example.demo.entity.Info;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @GetMapping(value = "/test")
    public Data get(Info info) {
        return dealWith(info);
    }

    @PostMapping(value = "/test")
    public Data post(Info info) {
        return dealWith(info);
    }

    /**
     * @param info  用户的信息
     * @return      处理用户信息的结果
     */
    private Data dealWith(Info info) {
        String nickname = info.getNickname();
        String gender = info.getGender();
        int age = info.getAge();

        if (StringUtils.isEmpty(nickname)) {
            return new Data().setCode(-1).setResult("Nickname can not be blank.");
        }

        if (StringUtils.isEmpty(gender)) {
            return new Data().setCode(-2).setResult("Gender can not be blank.");
        }else if (gender.equals("male")) {
            gender = "boy";
        }else if (gender.equals("female")) {
            gender = "girl";
        }else {
            return new Data().setCode(-2).setResult("Gender is not legal");
        }

        if (age < 0) {
            return new Data().setCode(-3).setResult("Age can not be less than zero.");
        }

        String result = nickname + "'s age is " + age + " year old, " + "he(she) is a " + gender;
        return new Data().setCode(0).setResult(result);
    }
}