package github.alexiuce.kt




class Dog(private var name: String, private var age: Int){

    /* 延时初始化属性 : 在使用之前进行初始化  懒加载
    *  var 成员 使用 lateinit
    *  val 成员 使用 by lazy{
    *  }
    *
    * */
    lateinit var country: String



    fun eat(food: String){
        println("$name eat.....$food")
    }

    fun sleep(time: Int){
        println("sleep.....$time second")
    }
}



fun main(args: Array<String>) {
    val d = Dog("wangcai", 2)

    d.eat("bone")
    d.sleep(30)
}