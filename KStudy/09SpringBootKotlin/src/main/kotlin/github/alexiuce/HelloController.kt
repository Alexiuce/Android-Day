package github.alexiuce

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*

/**
 * Created by caijinzhu on 2018/3/23.
 */

@RestController
class HelloController{

     @Autowired
     lateinit var girl: BeatifulGirl
//    @Value("\${name}")
//    var name: String = ""
//    @Value("\${cupSize}")
//    var cupSize: String = ""
//    @Value("\${age}")
//    var age: Int = 0

//    @RequestMapping(value = "/say", method = arrayOf(RequestMethod.GET))
    @RequestMapping("/say")
    fun say(): String {

    return "hello kotlin server"
    }
    @RequestMapping("/")
    fun hello(): String{
        return "Hello ${girl.name} , your cupSize is ${girl.cupSize} ,your age is ${girl.age}~ "

    }

}