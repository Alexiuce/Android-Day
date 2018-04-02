package alexiuce.github.com.servicekotlindemo

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ServiceConnection {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addEventListen()
    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
      println("connected service ")
    }

    override fun onServiceDisconnected(name: ComponentName?) {
       println("disconnected service")
    }
}

/** extension method  */
fun MainActivity.addEventListen(){
    button.setOnClickListener{
        println("click button for starting service")
        val intent = Intent(this,DemoService::class.java)
//        startService(intent)
        /** 如果服务已经绑定,不会多次执行绑定, bind方式的服务不能在手机的设置中找到 */
        bindService(intent,this,Service.BIND_AUTO_CREATE)


    }
    button2.setOnClickListener{
        println("click button for stop service")
        val intent = Intent(this,DemoService::class.java)
//        stopService(intent)
        /** 不能多次unbindService */
        unbindService(this)
    }
}
