package github.alexiuce

fun main(args: Array<String>) {
    // 阶乘计算
//    println(fact(5))

//    println(fabonaqi(7))

    println(rec_sum(10))

}


/* 递归层级比较深时,会造成栈内存溢出 ,为了解决这种问题,使用尾递归优化
 *
  * 函数在调用自己之后没有执行其他操作就是
  * */

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


/* 递归求和 */

fun rec_sum(n: Int): Int{
   return when(n) {
        1 -> 1
    else -> rec_sum(n - 1) + n
    }
}
