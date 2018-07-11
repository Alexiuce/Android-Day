
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









fun main(args: Array<String>) {

    val b = Box<String>("alex")
    println(b.thing)

    val a = Apple()
    val fb = FBox(a)
    println(fb.thing)

}