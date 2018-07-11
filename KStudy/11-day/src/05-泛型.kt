
/* 泛型:
* 1. 强类型开发语言中,定义一些可变的部分
*
*
* */




// 1. 定义类的时候定义泛型

open class Box<T>(var thing:T)


// 2. 定义子类时不确定泛型

class SubBox<T>(thing: T): Box<T>(thing)



// 3. 定义子类时,确定泛型
class FBox(thing: Fruit): Box<Fruit>(thing)


abstract class Fruit

class Apple: Fruit()
class Banana: Fruit()


/* ========================================== */

/* 泛型函数 */

fun <T>funcname(p: T){
    when (p) {
        is Int -> println("Int type")
        is Double -> println("Double type")
        is String -> println("String type")
        else -> println("don't know type")
    }
}




fun main(args: Array<String>) {

    // 使用泛型类
    val b = Box<String>("alex")
    println(b.thing)

    val a = Apple()
    val fb = FBox(a)
    println(fb.thing)

    // 使用泛型函数
    funcname("hello")
    funcname(b)

}