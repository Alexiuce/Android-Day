package github.alexiuce

fun main(args: Array<String>) {
    // 阶乘计算
    println(fact(5))

    println(fabonaqi(7))
}


fun fact(n: Int): Int{

    return if (n == 1) 1 else n * fact(n -1)


}

fun fabonaqi(n: Int): Int {

//    if (n <= 2){
//        return 1
//    }else{
//        return fabonaqi(n-2) + fabonaqi(n - 1)
//    }
    /* if 表达式写法 */
   return if (n <= 2) 1 else fabonaqi(n - 2) + fabonaqi(n - 1)


}
