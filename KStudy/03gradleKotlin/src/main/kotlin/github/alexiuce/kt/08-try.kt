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




fun main(args: Array<String>) {

    try {
        println("${args[0]} + ${args[1]} = ${args[0].toInt() + args[1].toInt()}")
    }catch (e:Exception){
        println("args error")
    }



}