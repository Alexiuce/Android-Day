package github.alexiuce

/** 函数表达式
 * 当函数体仅有一条语句时,可以省略{},省略return
 *
 *
 * */



fun my_add(a: Int,b:Int): Int{
    return a + b
}

fun my_add1(a: Int,b: Int) = a + b    // 函数表达式

fun main(args: Array<String>) {

    val c = my_add1(10,2)
    println(c)

}
