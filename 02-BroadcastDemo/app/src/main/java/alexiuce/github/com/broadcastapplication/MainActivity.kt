package alexiuce.github.com.broadcastapplication

import alexiuce.github.com.testlibrary.Person
import alexiuce.github.com.twolibrary.Two
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 点击按钮,发送无序广播
        button.setOnClickListener{
            val intent = Intent()
            intent.action = "MYBroadcast"
            intent.putExtra("job","dev")
            sendBroadcast(intent)

            sendbr
        }

    }

    private fun example(){
        val p = Person("alex")
        println(p)
        val t = Two()
        t.say()
        }
}
