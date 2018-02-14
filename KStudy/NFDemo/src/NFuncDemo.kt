import com.sun.org.apache.regexp.internal.REUtil
import java.math.BigInteger
import java.security.Guard

/**
 * Created by Alexcai on 2018/2/14.
 */
fun main(args: Array<String>) {

    val result = fact(BigInteger("100"))
    println(result)
}
/* 递归 : 阶乘*/
fun fact(num:Int):Int{
    if (num == 1){return 1}
    return num * fact(num -1)
}
/* 大数计算 */
fun fact(num:BigInteger):BigInteger{
    if (num == BigInteger.ONE){ return BigInteger.ONE }
    return num * fact(num - BigInteger.ONE)
}


/* 获取输入Dmeo*/
fun Demo(){
    println("please input a number :")
    var str = readLine()
    println("please input another number:")
    var str1 = readLine()
    if (str != null && str1 != null){
        val result = str!!.toInt() + str1!!.toInt()
        println("$str + $str1 = $result")
    }
}
/* 变量输出Demo */
fun demo1(){
    var a = "123"
    var b = 12

    a = b.toString()
    println("a  is  $a, b is $b")

    var text = """yellow tree in the rain ,
        white hair down the light
        """
    println( "this is a $text" + "length is ${text.length}")
}