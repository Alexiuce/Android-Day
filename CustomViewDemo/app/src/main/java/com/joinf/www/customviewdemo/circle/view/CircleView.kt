package com.joinf.www.customviewdemo.circle.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.View


/**
 * author: caijinzhu
 * function:
 * date: 2018/3/13
 */

class CircleView constructor(context: Context): View(context){



    private val paint = Paint()

    init {
        paint.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.GRAY
        paint.style = Paint.Style.FILL_AND_STROKE
        val radius = width / 4.0f
        val xy = width / 2.0f
        canvas?.drawCircle(width / 2.0f, width / 2.0f,radius,paint)
        paint.color = Color.BLUE
        val arc = RectF(xy - radius,xy - radius, xy + radius, xy + radius )
        canvas?.drawArc(arc,270.0f,120.0f,true,paint)

    }
}