package github.alexiuce


fun main(args: Array<String>) {
    var a = 0
    while (a < 100){

        a++
    }

    do {

        a++
    }while (a < 100)

/* 区间
*
* IntRange class
* 操作符重载  .. 正向区间
* downTo 反向区间
* reversed() 区间反转
*
*
* */
    val range1 = 1..10      // 1~10 包含1和10
    for (i in range1){
        println(i)
    }

    val range2 = 'a'..'h'
    for (c in range2){
        println(c)
    }
    val range3 = 10 downTo 4
    range3.forEach { println(it) }
}

