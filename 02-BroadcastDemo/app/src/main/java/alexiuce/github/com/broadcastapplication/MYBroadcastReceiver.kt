package alexiuce.github.com.broadcastapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * author: caijinzhu
 * function:
 * date: 2018/4/4
 */
class MYBroadcastReceiver: BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {


        val data = intent?.getStringExtra("job") ?: ""
        Toast.makeText(context,data,Toast.LENGTH_LONG).show()
    }
}