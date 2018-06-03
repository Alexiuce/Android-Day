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




fun main(args: Array<String>) {

    try {
        println("${args[0]} + ${args[1]} = ${args[0].toInt() + args[1].toInt()}")
    }catch (e:Exception){
        println("args error")
    }

    /* 具名参数调用函数 */
    val a = my_plus(1,arg2 = 3)
    println(a)

}