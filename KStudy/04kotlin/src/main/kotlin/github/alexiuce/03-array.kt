package github.alexiuce

fun main(args: Array<String>) {

    val array1 = arrayOf("zhangshan","lisi","wangwu")
    array1.forEach { println(it) }

    val array2 = IntArray(10){2}  // 创建一个长度为10 并且每个元素的初始值都是2 的数组
    array2.forEach { println(it) }
}