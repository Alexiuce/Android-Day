package com.example.alexcai.javacdemo;

/**
 * Created by Alexcai on 2017/10/29.
 */

public class JNIHelper {
    static {
        System.loadLibrary("JniDemo");
    }

    public native String stringFromC();
}
