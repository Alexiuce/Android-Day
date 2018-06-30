package github.alexiuce


fun main(args: Array<String>) {

    val a = 100
    when(a){
        in 0..59 -> println("不及格")
        in 60..79 -> println("好")
        in 80..89 -> println("良")
        in 90..100 -> println("优")
        else -> println("错误")
    }

}