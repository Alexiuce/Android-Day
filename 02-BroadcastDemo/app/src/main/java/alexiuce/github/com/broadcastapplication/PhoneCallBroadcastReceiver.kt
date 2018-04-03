package alexiuce.github.com.broadcastapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * author: caijinzhu
 * function:
 * date: 2018/4/3
 */

class PhoneCallBroadcastReceiver: BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        println("broadcast receive begin on.....")
    }

}