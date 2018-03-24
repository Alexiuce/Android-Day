package github.alexiuce

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by caijinzhu on 2018/3/23.
 */

@RestController
@RequestMapping("/hello")
class HelloController{

     @Autowired
     lateinit var girl: BeatifulGirl
//    @Value("\${name}")
//    var name: String = ""
//    @Value("\${cupSize}")
//    var cupSize: String = ""
//    @Value("\${age}")
//    var age: Int = 0

    @RequestMapping(value = ["/say"], method = [RequestMethod.POST])
    fun say(@RequestParam("id",required =false,defaultValue = "0" ) uid: Int): String {

        return "Hello ${girl.name} , your cupSize is ${girl.cupSize} ,your age is ${girl.age}~ your request id is $uid"
    }

}