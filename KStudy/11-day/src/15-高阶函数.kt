fun main(args: Array<String>) {

    // 获取函数的引用使用::
    val r = myCacl(10,20,::myAdd)
    println(r)

}


fun myAdd(a: Int, b: Int): Int{
    return a + b
}

// 一个函数的参数中可以接收另外一个函数的引用,就是被当作为高阶函数
fun myCacl(a: Int, b: Int, op: (Int,Int)->Int): Int{
    return op(a,b)
}