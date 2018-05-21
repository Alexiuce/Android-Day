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

    println("========= Int ============")
    val num: Int = 8
    println(num)
    println(Int.MAX_VALUE)
    val binnum: Int = 0b1100
    val hexnum: Int = 0xFF
    println(binnum)
    println(hexnum)

    println("========= Long ============")
    val aNumber: Long = 123
    println(34L)
    println(aNumber)
    println(Long.MAX_VALUE)
    val addNumber: Long = num.toLong() + aNumber      /* 基本数据类型转换, 需要调用toXXX() 方法 */
    println(addNumber)

    println("========= Float ============")
    val aFloat: Float = 1.23f
    println(aFloat)
    println(Float.NaN)

    val aDouble: Double = 3.14
    println(aDouble)

    println("========= Short ============")
    /** Short: 16bit */
    val aShort: Short = 234
    println(aShort)
    println(Short.MAX_VALUE)


    println("========= Byte ============")
    /** Byte: 8bit -128~127 */
    val aByte: Byte = 111
    println(Byte.MAX_VALUE)
    println(Byte.MIN_VALUE)


    /** Char, String */
    println("========= Char, String ============")
    val aChar: Char = 'a'
    println(aChar)

    val aString: String = "Hello world"
    val bString: String = String(charArrayOf('H','e','l','l','o',' ','w','o','r','l','d'))
    println(aString == bString)    // kotlin 中 字符串 使用 == 比较 完全等价于 调用 equals() 方法;
    println(aString === bString)   // === 比较的是内存地址是否相同

    /** 字符串模版 */
    println("$num + $binnum = ${num + binnum}")
    val mulString: String = """
        | HELLO GOOD
        | IS VARY MUCH
        | ANY MORE
    """.trimMargin()
    println(mulString)
    println(mulString.length)


    /** 类 */
    println(Person(21,"ajax"))


    HelloKotlin::class.constructors.map(::println)
}



class HelloKotlin{
    fun hello(){

    }
}

