package com.joinf.www.moduleapp.HttpTool.HttpRequestParams;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by caijinzhu on 2017/12/20.
 * http 请求参数封装到HashMap中
 */

public class RequestParams {
    public ConcurrentHashMap<String,String> urlParams = new ConcurrentHashMap<String, String>();
    public ConcurrentHashMap<String,Object> fileParams = new ConcurrentHashMap<String, Object>();


    public RequestParams(){this((Map<String, String>) null);}

    public RequestParams(Map<String,String> source){
        if (source == null){return;}
        for (Map.Entry<String,String> entry : source.entrySet()){
            put(entry.getKey(),entry.getValue());
        }
    }

    public RequestParams(final String key,final String value){
        this(new HashMap<String, String>(){
            {
                put(key, value);
            }
        });
    }

    public void put(String key, String value){
        if (key == null || value == null){return;}
        urlParams.put(key,value);
    }


    public void put(String key, Object obj) throws FileNotFoundException{
        if (key == null){return;}
        fileParams.put(key,obj);
    }

    public boolean hasParams(){
        return urlParams.size() > 0 || fileParams.size() > 0;
    }
}
