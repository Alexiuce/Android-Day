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
}



fun main(args: Array<String>) {

    val a = Clomplex(12.0,23.3)
    val b = Clomplex(22.1, 11.2)
    val c = a + b
    println(c)


}