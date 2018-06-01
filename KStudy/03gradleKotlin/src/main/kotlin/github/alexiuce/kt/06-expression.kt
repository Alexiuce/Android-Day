package github.alexiuce.kt



/* 分支表达式

* if 表达式
* when 表达式
* kotlin 已经没有switch语句

* */


fun if_test(){
    val a = 100


    val b = if (a in 0..30){
        "so vary bad"
    }else if (a in 31 until 60){
        "bad~"
    }else{
        "you are normal or good "
    }

    println(b)

}

fun when_test(){
    val a = 10
    val b = when(a){
        in 0..30 -> "too low..."
        in 31..59 -> "need work hard"
        else -> "you are lucky"
    }
    println(b)
}



fun main(args: Array<String>) {

    when_test()

}