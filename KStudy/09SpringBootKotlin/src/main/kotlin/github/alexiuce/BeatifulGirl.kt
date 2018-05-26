package github.alexiuce

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Created by caijinzhu on 2018/3/23.
 */


@Component
@ConfigurationProperties("girl")
class BeatifulGirl{
    lateinit var cupSize: String
    lateinit var name: String
    var age: Int = 0

}