




/* 抽象类
 *  使用关键字 abstract 声明
 *  不需要使用open关键字
 *  抽象类可以没有抽象的方法或属性
 *  抽象类反应的是本质,只能单继承
 *  抽象类可以继承自其他的承抽象类
 *
 */

abstract class Human{

    // 抽象属性
    abstract var color:String

    // 抽象方法
   abstract fun eat()

}


class CHuman: Human(), RideRun{
    override var color: String = "yellow"
    override fun eat() {
        println("kuaizi...")
    }

    

}



/* interface 接口
  *
  * kotlin 中,接口的属性不能有默认实现 ,(java可以)
  * java中,接口的方法不能提供默认实现, kotlin支持默认的接口方法实现
  *
  *
  *
  * */

interface RideRun{
    fun rideBike(){
        println("take")
    }
}



/*  嵌套类
1. 嵌套类属于静态类
2. 与外部类没有任何关系
 * */



class OuterClass{

    val name = "alex"
    class InnerClass{
        fun say(){
//            println(name)
        }
    }
}

/* 内部类
* 1. 在嵌套类前面添加关键字: inner
*
* */


class OutClass{
    var name = "alex-ce"

    inner class InClass{
        val name = "xiuce"
        fun sayH(){
            // 内部类访问外部类时,使用this@外部类名.属性名 
            println("${this@OutClass.name}")
        }
    }

}


fun main(args: Array<String>) {

//    val man = CHuman()
//    man.rideBike()
    // 创建嵌套类对象
    val inner = OuterClass.InnerClass()
    inner.say()
    // 创建内部类对象
    val inc1 = OutClass().InClass()
    inc1.sayH()

}