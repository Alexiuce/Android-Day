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

fun sayHello() = println("hello")

fun main(args: Array<String>) {

    val c = my_add1(10,2)
    println(c)
    sayHello()

    // 函数引用
    val f1 = ::my_add1   // 获取my_add1函数的引用,相当于f1 是my_add1函数的别名
    val d = f1(1,4)
    //f1.invoke(3,2) 可以处理函数引用为空的情况
    println(d)

    val xcadd: (Int,Int)->Int = {a:Int,b:Int -> a + b}  // 匿名函数
    println(xcadd(1, 2))

}
