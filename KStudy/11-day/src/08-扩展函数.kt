




fun main(args: Array<String>) {

    val first = "hello"
    println(first.myCheck())
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
 *
  *
  * */