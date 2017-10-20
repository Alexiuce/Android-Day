package com.example.alexiuce.webapplication.StringTools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by alexiuce on 2017/10/20.
 */

public class StringUtils extends Object {
    public static String streamToString(InputStream is){

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024] ;

        int temp = -1;


        try {
            while ((temp = is.read(buffer)) != -1){
                baos.write(buffer,0,temp);
            }
            return baos.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
