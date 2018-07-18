fun main(args: Array<String>) {

    val n = News("体育","世界杯")
    println(n.desc)
    println(n.component1()) // 第一个元素

}


/* 使用data 关键字 定义的类 即为数据类 默认实现下列方法:
* 1.成构造方法
* 2.get set 方法
* 3.toSting
* 4.hashcode
* 5.equals
* 6.参数
* 7.copy
* */
data class News(var title: String,var desc: String)