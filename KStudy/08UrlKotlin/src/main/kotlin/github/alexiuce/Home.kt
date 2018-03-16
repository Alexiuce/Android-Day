package github.alexiuce

import java.net.URL

/**
 * Created by caijinzhu on 2018/3/16.
 */

fun main(args: Array<String>) {

    val url = "http://www.httpbin.org/get"
 
    print("hello...")
    val result = URL(url).readText()
    println(result)
    print("good")



}