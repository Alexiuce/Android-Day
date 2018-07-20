fun main(args: Array<String>) {

    val f1 = blockFunc()
    f1()
    f1()
}


/*  闭包: 一个函数内部返回了一个内部函数,这个内部函数引用了外部函数的相关参数或变量 这个返回的内部函数,称之为闭包 (定义参考于python)
 * kotlin 中 闭包 就是lambda表达式  */

fun blockFunc(): ()->Unit{
    var a = 10
    return {
        println(a)
        a++
    }
}