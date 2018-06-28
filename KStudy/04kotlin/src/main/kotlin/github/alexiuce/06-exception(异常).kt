package github.alexiuce

import java.io.BufferedReader
import java.io.File
import java.io.FileReader


fun main(args: Array<String>) {
    val a = 10
    val b = 0

    /* 运行时异常 */
    try {
        a/b
    }catch (e: Exception){
        println("exception found")
    }finally {
        println("run code")
    }


    /** 编译时异常
     * kotlin 默认不检测编译时异常
     * */

    val file = File("abc.txt")
    val fileBuf = BufferedReader(FileReader(file))

}