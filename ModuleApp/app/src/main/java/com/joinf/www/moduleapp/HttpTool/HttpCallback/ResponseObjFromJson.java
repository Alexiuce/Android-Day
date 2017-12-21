package com.joinf.www.moduleapp.HttpTool.HttpCallback;

import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by caijinzhu on 2017/12/21.
 */

public class ResponseObjFromJson {
    public static Object parseJsonToObject(JSONObject json, Class<?> clazz){
        Gson gson = new Gson();
        return gson.fromJson(json.toString(),clazz);
    }
}
