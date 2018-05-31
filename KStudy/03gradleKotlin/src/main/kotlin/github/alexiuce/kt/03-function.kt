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

    /* lambda 表达式 (匿名函数):
    * { 参数1:参数类型, 参数2:参数列表 ->
    *
    *    语句体1
    *    语句体2
    *    ....
    *    返回值为最后一句语句体
    *
    * }
    *
    *如果函数的最后一个参数是lambda表达式,可以使用简化写法:
    * fun trailFuncDemo(a: Int, b: Int callback: ((Int)-> Unit)){
    *   c(a + b)
    * }
    *
    *
    *  trailFuncDemo(10,11){
        print(it)
       }
    * 如果lambda中使用了return ,则表示在调用lambda处执行return 而不是在表达式内部return
    * */
    val plus = {a: Int,b: Int -> a+b}
    println(plus(1,2))



    trailDemo(10,11){
        print(it)
    }

}


fun my_add(a: Int, b: Int): Int{
    return a + b
}


fun trailDemo(a: Int, b: Int, callback:((Int) -> Unit)){
    callback(a + b)
}

/* 使用变量 接收函数 : 匿名函数 */
val f = fun (x:Int): Long { return x.toLong()}