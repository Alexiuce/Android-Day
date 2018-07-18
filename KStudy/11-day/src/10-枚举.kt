fun main(args: Array<String>) {


    println(Week.星期一)

    println(COLOR.RED)
    println(COLOR.RED.r)
    

}


/* kotlin 枚举
*
* enum class 枚举名{
*   枚举值1,枚举值2
* }
*
* */


enum class Week{
    星期一,星期二,星期三,星期四,星期五,星期六,星期日
}

enum class COLOR(var r: Int, var g: Int, var b: Int){
    RED(255,0,0),
    GREEN(0,255,0),
    BLUE(0,0,255)
}