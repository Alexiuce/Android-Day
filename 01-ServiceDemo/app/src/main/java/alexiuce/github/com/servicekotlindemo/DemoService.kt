package alexiuce.github.com.servicekotlindemo

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.telecom.TelecomManager
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.widget.Toast

/**
 * author: caijinzhu
 * function:
 * date: 2018/3/31
 */
class DemoService: Service() {



    /**
     * 本地服务:自己应用的服务
     * 远程服务:其他应用的服务
     * */
    
    override fun onBind(intent: Intent?): IBinder {
        println("on Bind")
        return Binder()
    }


    /** 第一次创建的时候 : 应用运行期间仅会执行一次 关闭服务再次开起,只会调用startCommand方法*/
    override fun onCreate() {
        super.onCreate()
        println("on create")
    }

    /** 每次启动服务的时候调用 */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("on start command")
        return super.onStartCommand(intent, flags, startId)
    }

    /** 服务停止的时候调用*/
    override fun onDestroy() {
        super.onDestroy()
        println("on destroy")
    }

}

fun DemoService.testExample(ctx: Context){
    println("service test example")

    Toast.makeText(ctx,"service test example",Toast.LENGTH_SHORT).show()
}