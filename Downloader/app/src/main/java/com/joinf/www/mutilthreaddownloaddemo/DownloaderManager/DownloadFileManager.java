package com.joinf.www.mutilthreaddownloaddemo.DownloaderManager;

import android.content.Intent;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.time.Year;

/**
 * Created by caijinzhu on 2017/12/12.
 */

public class DownloadFileManager {


    public static int NOT_LAST_POSITION = -1;

    /** 是否已经有已经下载好的文件*/
    public static Boolean hasAreadyFile(String url){
        String filename = convertUrl2filename(url);
        File file = new File(filename);
        return file.exists();
    }

    /** 获取文件大小*/
    public static int downloadFileSize(String url){
        String filename = convertUrl2filename(url);
        File file = new File(filename);
        return (int) file.length();
    }


    /** 创建一个指定大小的空文件*/
    public static RandomAccessFile  createEmptyFile(String url, int size){

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(convertUrl2filename(url),"rw");
            raf.setLength(size);
            System.out.println("++++++++++++++++++");
            System.out.println("创建文件成功");
            System.out.println("++++++++++++++++++");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("~~~~~~~~~~~~~~~~~~");
            System.out.println("创建文件失败");
            System.out.println("~~~~~~~~~~~~~~~~~~");
        }
        return raf;

    }

    /** 获取随机访问文件*/
    public static RandomAccessFile getAccessFile(String url){
        RandomAccessFile rw = null;
        try {
            rw = new RandomAccessFile(convertUrl2filename(url), "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return rw;
    }

    /** 删除RWDAccess 临时文件*/
    public static void removeRWDTXTFiles(int tid){
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + tid + ".txt";
        File file = new File(filePath);
        if (file.exists()){
            file.delete();
        }
    }

    /** 获取上次下载位置记录,若没有,则返回-1*/
    public static int getlastSizeInRWDAccessFile(int tid){
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + tid + ".txt";
        File file = new File(filePath);
        if (file.exists() && file.length() > 0){
            try {
                FileInputStream ins = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ins));
                String lastSize = bufferedReader.readLine();
                ins.close();
                return Integer.parseInt(lastSize);
            } catch (Exception e) {
                e.printStackTrace();
                return NOT_LAST_POSITION;
            }
        }else {
            return NOT_LAST_POSITION;
        }
    }

    /** 根据线程id 创建临时txt文件*/
    public static  RandomAccessFile createRWDAccessFile(int tid){
        RandomAccessFile rw = null;
        try {
            String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + tid + ".txt";
            rw = new RandomAccessFile(filePath, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return rw;
    }

    /** 根据url地址 生成 存储的文件名*/
    private static String convertUrl2filename(String url){

        int leftIndex = url.lastIndexOf("/") + 1;
        String name = url.substring(leftIndex);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        return  path + File.separator + name;

    }

}
