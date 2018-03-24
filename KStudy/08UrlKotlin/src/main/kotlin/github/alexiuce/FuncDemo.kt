package github.alexiuce

/**
 * Created by caijinzhu on 2018/3/19.
 */

fun main(args: Array<String>) {

    val result = add(1,2)
    println(result)

    val i = {x:Int,y:Int -> x + y}
    println(i(1,11))

    val j : (Int,Int) -> Int = {x,y -> x+y}
    println(j(2,3))

}


/*fun add(x: Int, y: Int): Int{
    return x + y
}*/


fun add(x:Int,y:Int) = x + y