package github.alexiuce.kt


data class Clomplex(var real: Double, var imaginary: Double){
    /* 重载运算符 +
     * 每个运算符本质都是一个函数
     * 使用关键字 operator
      * */
    operator fun plus(other: Clomplex): Clomplex{
        val ar = real + other.real
        val ai = imaginary + other.imaginary
        return Clomplex(ar,ai)
    }

    /* 自定义运算符
    * 使用 中缀 infix(双目运算)  */
    infix fun BigThan(other: Clomplex): Boolean{
        return real > other.real
    }

}



fun main(args: Array<String>) {

    val a = Clomplex(32.0,23.3)
    val b = Clomplex(22.1, 11.2)
    val c = a + b
    println(c)
    println(a BigThan b)   // BigThan 是自定义的运算操作符号

}