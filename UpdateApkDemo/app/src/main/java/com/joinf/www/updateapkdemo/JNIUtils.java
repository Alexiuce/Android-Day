package com.joinf.www.updateapkdemo;

/**
 * Created by caijinzhu on 2017/12/15.
 */

public class JNIUtils {
    static {
        System.loadLibrary("JNISample");
    }
    public native String getHelLo();
}
