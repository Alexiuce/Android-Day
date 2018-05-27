package com.joinf.www.weatherkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Mon 6/24 - Foggy - 21/8",
            "Mon 6/25 - Cloudy - 22/17",
            "Mon 6/26 - Rainy - 18/11",
            "Mon 6/27 - Foggy - 21/10",
            "Mon 6/28 - TRAPPED IN .. - 23/18",
            "Mon 6/29 - Sunny - 20/7"
            )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecast_list.layoutManager = LinearLayoutManager(this)
        forecast_list.adapter = ForecastListAdapter(items)


    }

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this,message,length).show()
    }
}

