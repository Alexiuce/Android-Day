import kotlin.concurrent.thread

fun main(args: Array<String>) {

    val sm = SuperMarket()


    sm.buySoy {
        println("买到 ${it.name} 酱油")
        println("开始做饭")
    }

    println("做甜点")

    /*1. list 补充
    *  list.count{ it.name == "xxx"}  返回集合中符合条件的元素数量   
    *
    * */


}

/** 接口回调的流程
 * 1. 定义接口
 * 2. 传递接口对象
 * 3. 通过接口对象传递数据回去
 * 4. 在具有接口能力的对象中接收数据
 *
 * */


class SuperMarket{
    fun buySoy(callback: (Soy)-> Unit): Unit{
        Thread {
            val soy = Soy("海天")
            callback(soy)
        }.start()

    }

}

class Mother{

}


class Soy(var name: String){

}