package alexiuce.github.com.downloaderdemo

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Environment
import android.os.IBinder
import android.support.annotation.MainThread
import android.support.annotation.UiThread
import android.test.UiThreadTest
import android.widget.Toast
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.io.File
import java.io.FileDescriptor
import java.io.RandomAccessFile
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import kotlin.concurrent.thread

/**
 * author: caijinzhu
 * function:
 * date: 2018/3/27
 */
class DownloadService: Service(){

    companion object {
        val ActionStart = "ActionStart"
        val ActionEnd = "ActionEnd"
        val DownloadDefaultPath = Environment.getExternalStorageDirectory().absolutePath + "/downloads/"
    }

    private var downloadFileInfo: DownloadFileInfo? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val act = intent?.action ?: ""
        // 获取传递的参数
        downloadFileInfo = intent?.getSerializableExtra("fileInfo") as DownloadFileInfo
        if (downloadFileInfo == null) {return super.onStartCommand(intent, flags, startId)}
        when (act) {
            DownloadService.ActionStart -> startDownload()
            DownloadService.ActionEnd -> {
                println("end ${downloadFileInfo!!.filename}")
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder {
        return Binder()
    }

    private fun startDownload(){
        doAsync {
            // 网络请求
            val requestUrl = URL(downloadFileInfo!!.url)
            val conection = requestUrl.openConnection() as HttpURLConnection
            conection.connectTimeout = 5000   // 请求超时
            conection.requestMethod = "GET"   // 请求方法

            if (conection.responseCode != HttpsURLConnection.HTTP_OK){   // 请求错误
                return@doAsync
            }
            val fileLength = conection.contentLength
            if (fileLength <= 0){return@doAsync}   // 文件长度错误

            // 创建本地文件目录
            val path = downloadFileInfo?.savePath ?: DownloadService.DownloadDefaultPath
            val dirFile = File(path)
            if (!dirFile.exists()){   // 目录不存在,则创建目录
                dirFile.mkdir()
            }

            // 创建本地文件
//            val file = File(dirFile,downloadFileInfo!!.filename)
//            val randomAccessFile = RandomAccessFile(file,"rwd")
//            randomAccessFile.setLength(fileLength.toLong())  // 设置文件长度
//            randomAccessFile.close()
            downloadFileInfo?.length = fileLength
            uiThread {

                println(downloadFileInfo?.length)
            }

        }



    }


}

