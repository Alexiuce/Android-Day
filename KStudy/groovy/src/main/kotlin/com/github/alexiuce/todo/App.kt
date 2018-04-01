package com.github.alexiuce.todo

import ItemModel
/**
 * Created by caijinzhu on 2018/3/26.
 */

fun main(args: Array<String>) {

    var input = readLine()
    println(input)
    if (input == null) return
    while ( input!!.toInt() > 0){
        var item = ToDoItem("item$input",false)
        println(item)
        input = readLine()
    }

    val itemMode = ItemModel("hello mode for item")
    println(itemMode)

}