package com.example.alexcai.httpdemo;

import java.util.jar.Attributes;

/**
 * Created by caijinzhu on 2017/11/13.
 */

public class Person {
    private String Host;
    private String Connection;

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

    @Override
    public String toString() {
        return "Person{" +
                "Host='" + Host + '\'' +
                ", Connection='" + Connection + '\'' +
                '}';
    }
}
