package github.alexiuce.kt

/**
 * Created by caijinzhu on 2018/3/8.
 */

fun main(args: Array<String>) {

    /** 基本数据类型1: 布尔  */
    val isApp: Boolean = true
    val isIdea: Boolean = false
    println(isApp)


    /** 基本数据类型2: Number: Int, Long ,Float, Double, Short, Byte */

    val num: Int = 8
    println(num)
    println(Int.MAX_VALUE)
    val binnum: Int = 0b1100
    val hexnum: Int = 0xFF
    println(binnum)
    println(hexnum)

    val aNumber: Long = 123
    println(34L)
    println(aNumber)
    println(Long.MAX_VALUE)

    val aFloat: Float = 1.23f
    println(aFloat)
    println(Float.NaN)

    val aDouble: Double = 3.14
    println(aDouble)

    /** Short: 16bit */
    val aShort: Short = 234
    println(aShort)
    println(Short.MAX_VALUE)

    /** Byte: 8bit -128~127 */
    val aByte: Byte = 111
    println(Byte.MAX_VALUE)
    println(Byte.MIN_VALUE)


    /** 类 */
    println(Person(21,"ajax"))


    HelloKotlin::class.constructors.map(::println)
}



class HelloKotlin{
    fun hello(){

    }
}

