package alexiuce.github.com.downloaderdemo

import android.content.Context
import org.jetbrains.anko.db.*

/**
 * author: caijinzhu
 * function:
 * date: 2018/3/27
 */

class DownloadDBDelegate(private val ctx: Context): DownloadDBProcotol{

    override fun insertThreadInfo(info: DownloadThreadInfo) {
      val db = DownloadDBManager.getInstance(this.ctx).writableDatabase
        db.insert(DownloadDBManager.downloadTableName,"thread_id" to info.tid,
                "url" to info.url,
                "start" to info.start,
                "end" to info.end,
                "finishedCount" to info.finishedCount)
    }

    override fun deleteThreadInfo(url: String, tid: Int) {
        val db = DownloadDBManager.getInstance(this.ctx).writableDatabase
        db.delete(DownloadDBManager.downloadTableName,
                "url={url} and (thread_id={tid})",
                "url" to url,"tid" to tid)
    }

    override fun updateThreadInfo(url: String, tid: Int, finishedCount: Int) {

        val db = DownloadDBManager.getInstance(this.ctx).writableDatabase
        db.update(DownloadDBManager.downloadTableName,"finishedCount" to finishedCount)
                .whereArgs("url={url} and thread_id={tid}","url" to url,"tid" to tid )
                .exec()

    }

    override fun getThreads(url: String): ArrayList<DownloadThreadInfo> {
        val db = DownloadDBManager.getInstance(this.ctx).writableDatabase
        var result:ArrayList<DownloadThreadInfo> = arrayListOf()
        db.select(DownloadDBManager.downloadTableName)
                .whereArgs("url={targetUrl}","targetUrl" to url)
                .exec {
                    val rowParse = classParser<DownloadThreadInfo>()
                    result = parseList(rowParse) as ArrayList
                }
        return result
    }

    override fun threadisExist(url: String, tid: Int): Boolean {
       return getThreads(url).size > 0
    }
}