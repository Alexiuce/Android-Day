package com.example.alexcai.httpdemo;

/**
 * Created by caijinzhu on 2017/11/13.
 */

public class MyJson {
    private String data;
    private String url;
    private Person headers;

    public Person getHeaders() {
        return headers;
    }

    public void setHeaders(Person headers) {
        this.headers = headers;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MyJson{" +
                "data='" + data + '\'' +
                ", url='" + url + '\'' +
                ", headers=" + headers +
                '}';
    }
}
