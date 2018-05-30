package github.alexiuce.kt




fun main(args: Array<String>) {


    /* kotlin 中Array是不可变的, 因此数组没有增和删的操作; 如果需要可变类型,需要使用mutableList */
    val ints: IntArray = intArrayOf(1,2,3,4,5)
    val chars: CharArray = charArrayOf('a','b','c')
    val strings: Array<String> = arrayOf("hello","world")


    /* val 运行时常量
    *  const val : 定义编译期常量, 类似c/c++ 中的define
    * */

    ints.sliceArray(0..2).forEach { println(it) }


    ints.forEach { println(it) }

    println("------------------")
    println(chars.joinToString(""))
    chars.forEach {
        println(it)
    }
    for (i in strings){
        println(i)
    }
}