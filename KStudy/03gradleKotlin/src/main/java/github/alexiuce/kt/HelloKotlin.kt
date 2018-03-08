package github.alexiuce.kt

/**
 * Created by caijinzhu on 2018/3/8.
 */

fun main(args: Array<String>) {
    println(Person(21,"ajax"))


    HelloKotlin::class.constructors.map(::println)
}



class HelloKotlin{
    fun hello(){

    }
}