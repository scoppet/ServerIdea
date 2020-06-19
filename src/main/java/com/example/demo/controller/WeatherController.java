package com.example.demo.controller;

import com.example.demo.entity.Data;
import com.example.demo.utils.HttpUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/weather")
public class WeatherController {

    @GetMapping (value = "/weather")
    public static Data getWeather(String code){
        return getWeathers(code);
    }

    private static Data getWeathers(String code){
        String result = HttpUtils.doGet("http://t.weather.sojson.com/api/weather/city/"+code);
        return new Data().setCode(0).setResult(result);
    }

}
