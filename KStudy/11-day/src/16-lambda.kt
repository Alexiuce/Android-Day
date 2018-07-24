fun main(args: Array<String>) {


    // 1. 使用变量保存lambda
    val block = {a: Int, b: Int -> a + b}
    val result = block(1,4)
    println(result)

    // 2. lambda 中使用it隐含参数(lambda只有一个参数时)
    val r = haha(1){
        it + 10
    }
    println(r)
}


fun haha(a: Int,block:(Int)->Int): Int{
    return block(a)
}