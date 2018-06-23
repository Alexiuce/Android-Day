package github.alexiuce.kt




/* kotlin 中没有三元运算符
* if 表达式
*
* */


fun get_max(a: Int, b: Int): Int{

//   方式1
//    if (a > b){
//        return a
//    }else{
//        return b
//    }

//    方式2
    return if (a > b) a else b



}



fun main(args: Array<String>) {

    val m = get_max(10,23)
    println(m)

}