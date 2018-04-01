package alexiuce.github.com.downloaderdemo

import java.io.Serializable

/**
 * author: caijinzhu
 * function:
 * date: 2018/3/27
 */

data class DownloadFileInfo(val filename: String,val url: String, val savePath: String):Serializable{
    private var fid: Int = 0
    var length: Int = 0
    private var isFinished: Boolean = false
}