import java.lang.StringBuilder

fun main(args: Array<String>) {



    val result = html {
        head {

        }
        body {

        }

    }
    println(result)
}


/* HTML dsl 步骤
* 1. 定义方法
*
* */

fun html(block: Html.()->Unit): String{
    val h5 = Html()
    h5.block()
    return h5.toString()
}

/*2. 定义内部扩展函数 */
fun Html.head(bock: ()-> Unit){
    val h = Head()
    setTag(h)
}

/* 定义body func*/
fun Html.body(block: ()->Unit){
    val b = Body()
    setTag(b)
}



// 任何标签都属于Tag 的子类
open class Tag(var name: String){

    val tagList = ArrayList<Tag>()

    fun setTag(tag: Tag){
        tagList.add(tag)
    }

    override fun toString(): String {

        var sb = StringBuilder()
        sb.append("<$name>")


        tagList.forEach {
            sb.append(it.toString())
        }

        sb.append("</$name>")

        return sb.toString()
    }
}

class Html:Tag("Html"){

}

class Body: Tag("Body"){}
class Head: Tag("Head"){}
class Div: Tag("Div"){}
