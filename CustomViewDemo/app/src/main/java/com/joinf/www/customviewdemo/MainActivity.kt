package com.joinf.www.customviewdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.view.ViewGroup
import android.widget.LinearLayout

import com.joinf.www.customviewdemo.circle.view.CircleView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layout = findViewById<ViewGroup>(R.id.containerView)
        val view = CircleView(this)
        val viewLayoutParam = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        val scale = this.resources.displayMetrics.density
        viewLayoutParam.bottomMargin = (8 * scale + 0.5).toInt()
        viewLayoutParam.height = (100 * scale + 0.5).toInt()
        viewLayoutParam.width= (100 * scale + 0.5).toInt()
        view.layoutParams = viewLayoutParam
        layout.addView(view)

    }
}
