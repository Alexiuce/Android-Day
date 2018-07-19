import java.util.*

fun main(args: Array<String>) {


    val son1 = Father.JobSon()
    println(canGetMoney(son1))

    val son2 = OutSon()
    println(canGetMoney(son2))



    // listof 集合不能添加和修改元素
    var bs = listOf("a1","a2","a3")

    bs.forEach {
        println(it)
    }

    /* 可变集合*/
    val l1 = mutableListOf("li","zhang","wang")

    l1.add("zhaoa")
    l1.set(1,"jing")
    l1.forEach {
        println(it)
    }
    /* HashTable : 线程安全
    * HashMap: 线程不安全
    * */


}

/* 密封类: 类似加强化的枚举
*  普通枚举包含的是基础数据类型
*  密封类封装的 类的数据
*  使用关键字 sealed
* */


fun canGetMoney(man: Father): Boolean{

    return when(man){
        is Father.NickSon -> true
        is Father.JobSon -> true
        is Father.StevenSon -> true
        is Father.GateSon -> true
        else -> false
    }

}



sealed class Father{
    class NickSon: Father()
    class JobSon: Father()
    class StevenSon: Father()
    class GateSon: Father()

}


class OutSon: Father()

