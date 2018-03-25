package com.alexcai.appupdatemanager.UpdateModule

import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by Alexcai on 2018/3/25.
 */

class UpdateDownload(val downloadUrl: String, val savePath: String): Runnable{

    private var isDownloading = false
    private var downloadFileLenght = 0



    override fun run() {
        startRequest()
    }

    private fun startRequest()  {
        if (!Thread.currentThread().isInterrupted){
            val url = URL(downloadUrl)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connectTimeout = 5000
            connection.setRequestProperty("Connection","Keep-Alive")
            connection.connect()   // 开启链接请求
            downloadFileLenght = connection.contentLength
            
        }

    }

}