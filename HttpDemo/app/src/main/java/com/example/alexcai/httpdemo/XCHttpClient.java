package com.example.alexcai.httpdemo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by caijinzhu on 2017/11/9.
 */

public interface XCHttpClient {
    @GET("get")
    Call<ResponseBody> responForGet();
}
