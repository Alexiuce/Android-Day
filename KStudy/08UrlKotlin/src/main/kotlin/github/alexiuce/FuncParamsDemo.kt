package github.alexiuce

import java.lang.Math.pow

/**
 * Created by caijinzhu on 2018/3/19.
 */

val PI = 3.1415926f

fun main(args: Array<String>) {
    /* 默认参数和具名参数*/

    val a1 = getArea(10,10)
    println(a1)


    val l1 = getCircleLength(3.14f,2.0f)
    println(l1)

    val c2 = getCircleArea(3.14f,3.0f)
    println(c2)

    /*省略默认参数时,需使用具名参数传递数据*/
    val c3 = getCircleArea(radius = 4.0f)
    println(c3)
}

fun getArea(length: Int,width: Int): Int {
    return  length * width
}

fun getCircleLength(pi: Float = PI, radius: Float): Float{
    return 2 * pi * radius
}

fun getCircleArea(pi: Float = PI, radius: Float): Float{
    return  pi * pow(radius.toDouble(),2.0).toFloat()
}