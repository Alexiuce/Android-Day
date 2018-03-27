package alexiuce.github.com.downloaderdemo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * author: caijinzhu
 * function:
 * date: 2018/3/27
 */
class DownloadDBManager(ctx: Context):ManagedSQLiteOpenHelper(ctx,"MyDownloadDatabase"){

    companion object {
        val downloadTableName = "downloadThreadInfo"
        private var instance: DownloadDBManager? = null
        @Synchronized
        fun getInstance(ctx: Context): DownloadDBManager{
            if (instance == null){
                instance = DownloadDBManager(ctx)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // 创建表
        db?.createTable(downloadTableName, true,
                "id" to INTEGER + PRIMARY_KEY + UNIQUE + AUTOINCREMENT,
                "thread_id" to INTEGER,
                "url" to TEXT,
                "start" to INTEGER,
                "end" to INTEGER,
                "finishedCount" to INTEGER)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // 删除新表
        db?.dropTable(downloadTableName,true)
    }

}
