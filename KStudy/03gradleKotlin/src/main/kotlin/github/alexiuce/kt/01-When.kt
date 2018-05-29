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



fun main(args: Array<String>) {
    test()
}