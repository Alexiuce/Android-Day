package github.alexiuce

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by caijinzhu on 2018/3/23.
 */

@RestController
class HelloController{

    @Value("\${name}")
    var name: String = ""
    @Value("\${cupSize}")
    var cupSize: String = ""
    @Value("\${age}")
    var age: Int = 0

    @RequestMapping(value = "/hello", method = [RequestMethod.GET])
    fun say(): String {


        return "Hello $name , your cupSize is $cupSize ,your age is $age~"
    }

}