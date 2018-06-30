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


    getUserName("abc.com")

    printNumber(2,12,3,3)

}


/*  默认参数和具名参考

* 通过默认参数,可以减少使用方法的重载
具名参数: 调用函数时,通过参数名来指定具体值,这种方式时可以忽略调用函数时,参数的顺序问题
* */


fun getUserName(url: String,params: String = "GET"){
    println("path=$url, para= $params")
}




/*   可变参数 vararg
* */

fun printNumber(vararg a: Int){
    a.forEach { println(it) }
}
