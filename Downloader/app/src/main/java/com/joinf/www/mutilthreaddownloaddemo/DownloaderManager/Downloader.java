package com.joinf.www.mutilthreaddownloaddemo.DownloaderManager;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.SimpleTimeZone;

/**
 * Created by caijinzhu on 2017/12/12.
 */

public class Downloader {

    private static final int THREAD_COUNT = 3;  // 下载线程数

    private static int runningThreadCount;      // 正在下载的线程数
    /** 下载文件 */
    public  static void downloadFileOnURL(final String  downloadUrl){

        new Thread(new Runnable() {
            @Override
            public void run() {
        /** 1.获取文件的大小 */
        try {
            URL url = new URL(downloadUrl);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 200){
                runningThreadCount = THREAD_COUNT;
                /** 获取服务器文件长度*/
                int apkLength = urlConnection.getContentLength();

                /** 判断本地是否已经有下载好的缓存文件*/
                if (DownloadFileManager.hasAreadyFile(downloadUrl) && DownloadFileManager.downloadFileSize(downloadUrl) == apkLength){
                    System.out.println("已存在下载好的文件");
                    return;
                }


                int downSize = apkLength / THREAD_COUNT;
                /** 根据url创建大小匹配的空文件*/
                DownloadFileManager.createEmptyFile(downloadUrl, apkLength);

                /** 计算每个下载线程的下载范围 */
                for (int i = 0; i < THREAD_COUNT; i++){
                    int startIndex = i * downSize;
                    int endIndex = (i + 1) * downSize - 1;
                    if (i == THREAD_COUNT - 1){
                        endIndex = apkLength - 1;
                    }
                    /** 开启线程,下载*/
                    DownloadThread downloadThread = new DownloadThread(startIndex, endIndex, i, downloadUrl, new DownloadThreadProtocol() {
                        @Override
                        public void finishThreadDownload(int tid) {
                            System.out.println("线程" + tid + ": 完成下载");
                            synchronized (this){
                                runningThreadCount--;
                                if (runningThreadCount == 0){   // 下载完毕,删除临时的记录文件
                                    for (int i = 0; i < THREAD_COUNT; i++){
                                        DownloadFileManager.removeRWDTXTFiles(i);
                                    }

                                }

                            }
                        }
                    });
                    downloadThread.start();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

            }
        }).start();



    }

}
