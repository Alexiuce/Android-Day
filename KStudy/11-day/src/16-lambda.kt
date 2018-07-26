fun main(args: Array<String>) {


    // 1. 使用变量保存lambda, lambda中返回值是最后一行,不需要使用return语句;
    val block = {a: Int, b: Int -> a + b}
    val result = block(1,4)
    println(result)

    // 2. lambda 中使用it隐含参数(lambda只有一个参数时)
    val r = haha(1){
        it + 10
    }
    println(r)
    /* 3. 常见的lambda
    * forEach: 是扩展函数,它的参数是一个函数,
    * indexOfFirst: 是array的扩展函数,参数是一个函数
    * filter:扩展函数,有一个参数是函数类型,这个函数中的参数的类型是集合元素的类型,返回值是Boolean
    * filterTo: 扩展函数,过滤元素到指定的一个集合中
    * filterIndex: 带索引过滤
    * sorted: 排序
    * groupBy: 分组
    * */

    val str = "abckdef"
    str.forEach(::myPrint)


    val l1 = listOf("z","d","b")
    println(l1.sorted())  // 排序
    println(l1.sortedDescending())  // 倒序

    /* 4. 分组 */


}


fun haha(a: Int,block:(Int)->Int): Int{
    return block(a)
}

fun myPrint(c:Char){
    println(c)
}

