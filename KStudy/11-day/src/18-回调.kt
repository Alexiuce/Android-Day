import java.text.SimpleDateFormat
import java.util.*
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
    * */

    /*2 通过Calendar 获取当前时间 */
    val year = Calendar.getInstance().get(Calendar.YEAR)
    println(year)
    val y = 23 in 20 until  30 // ==  [20,30) ;    // 20..30 == [20,30]

    println(y)

    /*3. SimpleDateFormat 时间格式化 */
    val df = SimpleDateFormat("yyyy-MM-dd")
    val time = df.parse("2016-10-13").time
    println(time)


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