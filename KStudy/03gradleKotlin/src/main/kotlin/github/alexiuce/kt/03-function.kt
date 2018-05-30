package github.alexiuce.kt




/* function 函数
 *
  格式: fun 函数名(形参名: 参数类型, 形参1: 参数类型1...等参数列表): 返回值类型{
    函数体
  }
  若无返回值,则使用Unit 表示
  默认Unit可以省略

  * */

fun main(args: Array<String>) {

    println(my_add(10, 2))

    println(f(10))
}


fun my_add(a: Int, b: Int): Int{
    return a + b
}

/* 使用变量 接收函数 : 匿名函数 */
val f = fun (x:Int): Long { return x.toLong()}