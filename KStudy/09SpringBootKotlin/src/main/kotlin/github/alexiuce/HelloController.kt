package github.alexiuce

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by caijinzhu on 2018/3/23.
 */

@RestController
class HelloController{
    
    @RequestMapping(value = "/hello", method = [RequestMethod.GET])
    fun say(): String {
        return "Hello kotlin Spring Boot~"
    }

}