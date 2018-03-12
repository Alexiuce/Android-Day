package github.alexiuce

import com.google.gson.Gson
import sun.jvm.hotspot.runtime.StackFrameStream
import sun.rmi.rmic.iiop.StaticStringsHash
import java.io.File
import javax.management.openmbean.ArrayType

/**
 * Created by caijinzhu on 2018/3/12.
 */


data class Rating(val username: String,val text: String, val avatar: String)
data class Good(val name: String, val price: Double, val icon: String)

data class Seller(val name: String, val avatar: String, val sellCount:Int)

data class DataJaon(val seller:Seller, val goods: ArrayList<Good>, val ratings:ArrayList<Rating>)



fun main(args: Array<String>) {
    val json = File("data.json").readText()
    val result = Gson().fromJson(json,DataJaon::class.java)
    println(result)

}