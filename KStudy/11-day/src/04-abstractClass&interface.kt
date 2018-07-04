




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




fun main(args: Array<String>) {

    val man = CHuman()
    man.rideBike()

}