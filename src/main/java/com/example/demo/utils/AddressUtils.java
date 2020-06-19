package com.example.demo.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

public class AddressUtils {

    public static JsonArray getAllAddressJsonArray(){
        JsonArray jsonArray = new JsonArray();
        JsonParser parser = new JsonParser();
        try {
            jsonArray =(JsonArray) parser.parse(new FileReader("F:\\IdeaProjects\\demos\\src\\main\\resources\\city.json"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonArray;
    }

    public static String getAddressCodeByAddress(String address){
        JsonArray allArray = getAllAddressJsonArray();
        String[] add = address.split("-");
        JsonArray cityArray = new JsonArray(), areaArray = new JsonArray();
        for (int i = 0; i < allArray.size(); i++) {
            JsonObject object = (JsonObject) allArray.get(i);
            if(StringUtils.removeDoubleQuote(object.get("provinceName").toString()).equals(add[0])){
                cityArray = object.getAsJsonArray("citylist");
            }
        }
        for (int i = 0; i < cityArray.size(); i++) {
            JsonObject object = (JsonObject) cityArray.get(i);
            if(StringUtils.removeDoubleQuote(object.get("cityName").toString()).equals(add[1])){
                areaArray = object.getAsJsonArray("arealist");
            }
        }
        for (int i = 0; i < areaArray.size(); i++) {
            JsonObject object = (JsonObject) areaArray.get(i);
            if(StringUtils.removeDoubleQuote(object.get("areaName").toString()).equals(add[2])){
                return StringUtils.removeDoubleQuote(object.get("id").toString());
            }
        }
        return "unknown address";
    }

}
