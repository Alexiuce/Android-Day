




fun main(args: Array<String>) {

    val first = "hello"
    println(first.myCheck())

    NetTool.sayH()
}


/* 扩展函数:
* 1. fun 类 + 自定义方法
* 2. 扩展函数内可以方法类的内部数据
* 3. 扩展函数可以被子类继承,但不能被子类复写
*
* */


fun String.myCheck(): Boolean{
    return this.isEmpty() || this.length <= 5
}

/* 单利模式: 饿汉方式(Java常用) , 懒汉方式(Objective-C常用)
*  1. kotlin 中使用object 代替class 定义单利
*  2. object中所有的字段都是静态,方式不是静态
*  3. object 对字段不多时比较合适
* */



object NetTool{
    var name = "jobs"
    fun sayH(){
        println(name)
    }
}