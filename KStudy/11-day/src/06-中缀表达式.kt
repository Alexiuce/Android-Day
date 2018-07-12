




/* 中缀表达式: 使得代码更加简介  在DSL中广泛使用
 * 1. 使用关键字 infix
  * 2. 自定义操作符
  * 使用条件:
  * 1. 必须是成员函数或扩展函数
  * 2. 函数必须只有一个参数
  * 3. 参数不能是可变参数或默认参数
  * */



class TeachMan{

  infix  fun sayHello(name: String){
        println("hello $name")
    }
}






fun main(args: Array<String>) {

    val t1 = TeachMan()
    t1.sayHello("job")

    // 使用中缀表达式
    t1 sayHello "alex"

}