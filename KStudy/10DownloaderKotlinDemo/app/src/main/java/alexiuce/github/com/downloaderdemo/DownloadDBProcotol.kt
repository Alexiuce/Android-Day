package alexiuce.github.com.downloaderdemo

/**
 * author: caijinzhu
 * function: 数据库DAO接口
 * date: 2018/3/27
 */

interface DownloadDBProcotol{

    /** 插入线程信息到数据库*/
    fun insertThreadInfo(info: DownloadThreadInfo)
    /** 从数据库中删除线程信息: 线程url和线程id */
    fun deleteThreadInfo(url: String, tid: Int)
    /** 更新数据库中的线程信息: 线程url和线程id */
    fun updateThreadInfo(url: String, tid: Int,finishedCount: Int)
    /** 从数据库中获取所有线程信息: 依据线程的url */
    fun getThreads(url: String): ArrayList<DownloadThreadInfo>
    /** 判断线程是否存在*/
    fun threadisExist(url: String,tid: Int): Boolean
}
