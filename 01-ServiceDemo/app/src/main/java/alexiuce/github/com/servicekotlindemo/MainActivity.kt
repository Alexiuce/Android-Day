package alexiuce.github.com.servicekotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addEventListen()
    }
}

/** extension method  */
fun MainActivity.addEventListen(){
    button.setOnClickListener{
        println("click button for starting service")
        val intent = Intent(this,DemoService::class.java)
        startService(intent)
    }
    button2.setOnClickListener{
        println("click button for stop service")
        val intent = Intent(this,DemoService::class.java)
        stopService(intent)
    }
}