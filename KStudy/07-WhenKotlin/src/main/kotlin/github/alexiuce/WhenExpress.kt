package github.alexiuce

/**
 * Created by caijinzhu on 2018/3/13.
 */


fun main(args: Array<String>) {


    example()
    returnValueExample(2)

}

fun example(){
    val score = 2

    when(score){
        10 -> println("full....")
        9 -> println("very good...")
        8 -> println("good ...")
        7 -> println("normal....")
        6 -> println("just be...")
        else -> println("need work hard...")
    }


}

fun returnValueExample(number: Int): String {
    var result = when(number){
        1 -> "one"
        2 -> "two"
        3 -> "three"
        4 -> "four"
        5 -> "five"
        6 -> "six"
        else -> "many"
    }
    println(result)
    return  result
}