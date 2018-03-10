/**
 * Created by Alexcai on 2018/2/14.
 */


fun main(args:Array<String>){
    println("hello kotlin")

    val aByte:Byte = Byte.MIN_VALUE
    val bByte:Byte = Byte.MAX_VALUE
    println("a min $aByte")
    println("b max $bByte")

    test()
    println(Student(20,"alex"))

}


data class Student(val sid: Int, val name: String)

fun test(){
    println("test func run")

}