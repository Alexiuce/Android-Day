package com.example.caijinzhu.activitydemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.NfcEvent;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by caijinzhu on 2017/12/18.
 */

public class PictureManager {

    /** 图片质量压缩:
     * iamge : 需要压缩的位图
     * maxCompresSize: 压缩后的最大size
     ### 注意: 如果最大压缩无法达到,这个方法可能会while 无限循环
     * */
    private static Bitmap compressPicture(Bitmap image,int maxCompressSize){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
        int compressOption = 100;
        while (outputStream.toByteArray().length / 1024 > maxCompressSize){
            outputStream.reset();
            compressOption -= 10;
            image.compress(Bitmap.CompressFormat.JPEG,compressOption,outputStream);
        }
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return BitmapFactory.decodeStream(inputStream,null,null);
    }

}
