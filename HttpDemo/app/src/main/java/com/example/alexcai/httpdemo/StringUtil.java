package com.example.alexcai.httpdemo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by Alexcai on 2017/11/5.
 */

public class StringUtil {
    public static String stringFromInputStream(InputStream in) throws Exception {


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int flag = -1;
        byte [] buffer = new byte[1024];
        while ((flag = in.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer,0,flag);
            }

        in.close();
        String result = new String(byteArrayOutputStream.toByteArray());
        return result;
    }
}
