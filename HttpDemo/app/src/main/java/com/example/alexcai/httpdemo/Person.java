package com.example.alexcai.httpdemo;

import com.google.gson.annotations.SerializedName;

import java.util.jar.Attributes;

/**
 * Created by caijinzhu on 2017/11/13.
 */

public class Person {
    private String Host;
    private String Connection;
    @SerializedName("User-Agent")
    private String userAgent;

    public String getHost() {
        return Host;
    }

    public void setHost(String host) {
        Host = host;
    }

    public String getConnection() {
        return Connection;
    }

    public void setConnection(String connection) {
        Connection = connection;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Host='" + Host + '\'' +
                ", Connection='" + Connection + '\'' +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }
}
