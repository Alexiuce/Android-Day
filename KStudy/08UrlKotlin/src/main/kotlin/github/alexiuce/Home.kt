package github.alexiuce

import java.net.URL

/**
 * Created by caijinzhu on 2018/3/16.
 */

fun main(args: Array<String>) {
    val list = listOf("crop","wheat","rice")
    for (item in list){
        println(item)
    }
    for ((i,e) in list.withIndex()){
        println("index = $i element = $e")
    }


}

fun demo1(){
    val url = "http://www.httpbin.org/get"

    print("hello...")
    val result = URL(url).readText()
    println(result)
    print("good")
}