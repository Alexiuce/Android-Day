package github.alexiuce

fun main(args: Array<String>) {
    // 阶乘计算
    println(fact(5))
}


fun fact(n: Int): Int{

    return if (n == 1) {1} else {n * fact(n -1)}


}

fun fabonaqi(n: Int): Array<Int> {
    
}
