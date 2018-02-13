import MYBeans.Student
import com.kotlin.annotations.NBean
import org.springframework.context.support.FileSystemXmlApplicationContext


/**
 * Created by caijinzhu on 2018/2/11.
 */


class main{

     fun test(){
        val context = FileSystemXmlApplicationContext("applicationContext.xml")
        val stud = context.getBean("stu") as Student
        val nb = context.getBean("nb") as NBean
        println(stud)
        println(nb)

    }
}


