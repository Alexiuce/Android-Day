package github.alexiuce.kt

// 异常捕获  (表达式)
/*
*  try {
        doing something
    }catch (e1){
        doing error1 handler
    }catch (e2){
        doing error2 handler
    }
    ...
    finally{
        doing last thing...
    }

    val a = try{
        1
    }catch(e){
        0
    }

* */

// 具名参数 : 调用函数时,传递参数时带上形参的名称
// 变长参数 : vararg 形参名称    (变长参数可以在方法或者函数的任意位置)
// 默认参数: 定义函数时,指定形参的值


fun my_plus(arg1: Int, arg2:Int): Int = arg1 + arg2

fun my_test(vararg ages: Int, name: String){
    println(name)
    ages.forEach(::println)
}

//  add demo
//  类, when表达式 lambde表达式
//

fun my_cacl_test(){
    val result = Caculate("*").cacl(2,3)
    println("cacl result is $result")
}


fun main(args: Array<String>) {

    try {
        println("${args[0]} + ${args[1]} = ${args[0].toInt() + args[1].toInt()}")
    }catch (e:Exception){
        println("args error")
    }

    /* 具名参数调用函数 */
    val a = my_plus(1,arg2 = 3)
    println(a)

    my_test(1,3,5,name = "goo")
    val myi = intArrayOf(1,2,3,5)
    my_test(*myi,name = "array ")   // 使用*+Array可以自动展开内部元素传递给变长参数


    my_cacl_test()

}