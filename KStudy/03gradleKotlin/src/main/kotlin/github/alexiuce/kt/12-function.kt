package github.alexiuce.kt


fun main(args: Array<String>) {
    sayHello()
    say("alex")
    val l = getNameLength("xiuce")
    println(l)
}


fun sayHello(){
    println("hello")
}

fun say(name: String){
    println(name)
}

fun getNameLength(name: String): Int{
    return name.length
}

/** 顶层函数
 *
 *  不是定义在对象内部的函数都是顶层函数
 *
 * */




/** 嵌套函数
 *
 * 在函数内部再次定义函数
 *
 * */