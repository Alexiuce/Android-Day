package github.alexiuce

fun main(args: Array<String>) {


    val g = Girl()

    println(g.name)
    g.sayHello()
}


class Girl{
    // 属性
    var name = "lin"
    var age = 10
    // 行为
    fun sayHello(){
        println("hello girl")
    }
}