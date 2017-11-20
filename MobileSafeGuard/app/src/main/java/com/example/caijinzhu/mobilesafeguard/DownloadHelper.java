package com.example.caijinzhu.mobilesafeguard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by caijinzhu on 2017/11/20.
 */

public class DownloadHelper {

   /** okhtttp client */
   private final OkHttpClient mHttpClient;
   private final String mDownloadURL;
   private final String mSavePath;
   private final String mSaveFilename;

   /** 构造方法*/
   public DownloadHelper(String url,String targetPath,String saveFilename) {
        mHttpClient = new OkHttpClient();
        mDownloadURL = url;
        mSavePath = targetPath;
        mSaveFilename = saveFilename;
    }

    /** 开启下载 */
    public void startDownload(final DownloadHelperListener listener){
        final Request request = new Request.Builder().url(mDownloadURL).build();
        mHttpClient.newCall(request).enqueue(new Callback() {
            /** 下载失败*/
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onDownloadFailed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream inStream = null;
                FileOutputStream fos = null;
                byte[] buffer = new byte[1024];
                int len = -1;
                try {
                    inStream = response.body().byteStream();
                    long allCount = request.body().contentLength();
                    File file = new File(mSavePath,mSaveFilename);
                    fos = new FileOutputStream(file);
                    int sum = 0;
                    while ((len = inStream.read(buffer)) != -1){
                        sum += len;
                        fos.write(buffer,0,len);
                        int progress = (int) (((sum * 1.0f) / allCount) * 100);
                        listener.onDownloadProgress(progress);
                    }
                    fos.flush();  // 将缓存数据写入文件
                    // 下载完成
                    listener.onDownloadSuccess();
                }catch (IOException e){
                    listener.onDownloadFailed(e);
                }finally {
                    try {
                        if (inStream != null){
                            inStream.close();
                        }
                    }catch (IOException e){}
                    try {
                        if (fos != null){
                            fos.close();
                        }
                    }catch (IOException e){}
                }
            }
        });

    }


    /** 下载回调接口 */
    public interface DownloadHelperListener{
        /** 下载成功*/
        void  onDownloadSuccess();
        /** 下载失败*/
        void  onDownloadFailed(IOException error);
        /** 下载进度*/
        void  onDownloadProgress(int progress);

    }
}
