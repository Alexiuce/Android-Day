package github.alexiuce.kt

import java.math.BigDecimal

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
    println(num.hashCode())
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


    /** */
    println("========= BigDecimal ============")
    val money: BigDecimal = BigDecimal("1.23456789123")
    println(money)


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

    val meizi = Meizi("温柔","good","sweet")

    println(meizi is CPerson)  /* 判断是否是某个类的或其子类 */


    /** 可选类型 */
    val opt: String? = "Hello"
    println(opt!!.length)    /* !! 对可选类型进行强制解包,如果可选类型为null 则crash */

    val name = fetchName() ?: return    /* ?: 运算符 如果条件成立则执行 ?:前的 否则执行后面的 */
    println(name)

    /* as(如果转换失败,会抛出异常) & as?(转换失败,则为null) 类型转换 */

    val ch = HelloKotlin() as? CPerson
    println(ch)

    HelloKotlin::class.constructors.map(::println)

    println(getName().length)
    

}


open class CPerson(var 性格: String, var 长相: String, var 声音: String){
    init {
        println("get a ${this.javaClass.simpleName}....")
    }
}

/** 类的继承
 *  Kotlin 中,所有类都间接的继承自 Any
 *  自定义类默认都是final类型,不能被继承
 *  open 的类可以继承
 * */
class Meizi(sl: String, face: String, voice: String):CPerson(sl,face,voice)


class HelloKotlin{
    fun hello(){

    }
}

/* 函数
* func 函数名(参数lieb): 返回值类型{
* }
* */

fun getName(): String{
    return "alexiuce"
}

fun fetchName(): String?{
    return "xiuce"
}