package com.example.alexcai.httpdemo;

import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by caijinzhu on 2017/11/9.
 */

public interface XCHttpClient {
    @GET("get")     // 设置请求方法和url路径
    Call<ResponseBody> responForGet();   // 返回一个请求Call对象,类似于iOS的 Http request


    @POST("post")
    Call<ResponseBody> requestForPost(@QueryMap HashMap<String,Object> params);
    @POST("post")
    Call<ResponseBody> requestForPostQuery(@Query("username") String username,@Query("city") String city);

    @POST("post")
    Call<ResponseBody> requestForPostBody(@Body RequestBody body);

}
