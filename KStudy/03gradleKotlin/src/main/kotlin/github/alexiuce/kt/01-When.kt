package github.alexiuce.kt



fun test(){
    val age = 8
    val result = when(age){
        in 1..6 -> "not begin study"
        7 -> "one level study"
        8 -> "two level study"
        9 -> "three level study"
        else -> "worker"
    }
    println(result)
}

fun rangTest(){
    val r1: IntRange = 0..100        /* range : 0 ~ 100 */
    for (i in r1.iterator()){
        println(i)
    }
    println("=================")
    val r2: IntRange = 0 until 50     /* range : 0 ~ 49 */
    for (i in r2.iterator()){
        print(i)
    }
    println( 30 in r1)

}



fun main(args: Array<String>) {
    test()
    println("hello".isEmpty())

    "World".forEach {
        println(it)
    }

    rangTest()

}