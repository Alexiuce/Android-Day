package com.joinf.www.mutilthreaddownloaddemo.DownloaderManager;

import android.app.Application;
import android.content.Context;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by caijinzhu on 2017/12/12.
 */

public class DownloadThread extends Thread {

    private int start,end,threadId;
    private String downloadingURL;

    private DownloadThreadProtocol finishCall;

    public DownloadThread(int startIndex,int endIndex,int tid,String url,DownloadThreadProtocol finishedCallback){
        start = startIndex;
        end = endIndex;
        threadId = tid;
        downloadingURL = url;
        finishCall = finishedCallback;
    }


    @Override
    public void run() {
        try {
            URL url = new URL(downloadingURL);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setConnectTimeout(5000);
            urlConnection.setRequestMethod("GET");

            /**获取上次下载位置*/
            int lastPosition = DownloadFileManager.getlastSizeInRWDAccessFile(threadId);

            if (lastPosition != DownloadFileManager.NOT_LAST_POSITION){
                start = lastPosition;
            }

            /** 设置请求范围*/
            urlConnection.setRequestProperty("Range","bytes="+start+"-"+end);
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 206){ // 206 代表请求部分资源 200 代表所有资源
                InputStream inps = urlConnection.getInputStream();
                RandomAccessFile raf = DownloadFileManager.getAccessFile(downloadingURL);
                /** 设置写入的偏移位置*/
                raf.seek(start);

                int currentSize = 0;   // 当前下载量

                int totalSize = 0;      // 总共下载量

                int len ;
                byte[] buffer = new byte[1024 * 1024 * 8];
                while((len = inps.read(buffer)) != -1){
                    raf.write(buffer,0,len);
                    totalSize += len;
                    currentSize = start + totalSize;



                    // 保存当前下载位置
                    RandomAccessFile rwdAccessFile = DownloadFileManager.createRWDAccessFile(threadId);
                    rwdAccessFile.write(String.valueOf(currentSize).getBytes());
                    rwdAccessFile.close();

                }
                raf.close();

                finishCall.finishThreadDownload(threadId);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
