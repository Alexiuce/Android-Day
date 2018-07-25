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
    *
    * */

    val str = "abckdef"
    str.forEach(::myPrint)
}


fun haha(a: Int,block:(Int)->Int): Int{
    return block(a)
}

fun myPrint(c:Char){
    println(c)
}

