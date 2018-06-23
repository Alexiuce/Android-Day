package github.alexiuce

fun main(args: Array<String>) {

    val array1 = arrayOf("zhangshan","lisi","wangwu")
//    array1.forEach { println(it) }
//
    val array2 = IntArray(10){2}  // 创建一个长度为10 并且每个元素的初始值都是2 的数组


    array2[1] = 33
    array2.set(0,5)
    array2.forEach { println(it) }

    /* 查找数组内的元素 */
    val i = array2.indexOf(2)
    println(i)

    val l = array1.indexOfFirst { it.startsWith("l") }   /* 获取数组中第一个l开始的字符串 */

    println(l)

}