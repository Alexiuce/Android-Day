package alexiuce.github.com.downloaderdemo

/**
 * author: caijinzhu
 * function: 下载线程信息
 * date: 2018/3/27
 */
data class DownloadThreadInfo(val filename: String){
    private var tid = 0   // 线程id
    private var start: Int = 0  // 下载起始位置
    private var end: Int = 0    // 下载停止位置
    private var finishedCount = 0  // 完成下载的数量
}