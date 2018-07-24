fun main(args: Array<String>) {




    // 1. 获取函数的引用使用::
    val r = myCacl(10,20,::myAdd)
    println(r)

    // 2. lambda 表达式 (匿名函数) : 可以作为函数的参数传递,也可以单独存在使用

    val r1 = myCacl(1,3,{m,n -> m + n })
    println(r1)
    
    // 3. 函数的最后一个参数是lambda时,可以把()移到前面
    val r2 = myCacl(2,3){m,n ->
        m + n
    }
    println(r2);

    // 4. 无参的lambda
    {
        println("hello advance lambda")
    }();
    // 5. 有参数的lambda
    { a: Int, b: Int ->
        println("a = $a, b = $b")
    }(10,2)

}


fun myAdd(a: Int, b: Int): Int{
    return a + b
}

// 一个函数的参数中可以接收另外一个函数的引用,就是被当作为高阶函数
fun myCacl(a: Int, b: Int, op: (Int,Int)->Int): Int{
    return op(a,b)
}

