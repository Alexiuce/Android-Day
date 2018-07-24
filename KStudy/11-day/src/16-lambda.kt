fun main(args: Array<String>) {


    // 1. 使用变量保存lambda
    val block = {a: Int, b: Int -> a + b}
    val result = block(1,4)
    println(result)

    // 2. 
}


fun haha(a: Int,block:(Int)->Int): Int{
    return block(a)
}