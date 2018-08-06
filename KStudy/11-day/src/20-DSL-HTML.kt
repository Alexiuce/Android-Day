import java.lang.StringBuilder

fun main(args: Array<String>) {

    val html = Html()
    println(html)

    val body = Body()
    val head = Head()
    val div = Div()
    html.setTag(head)
    head.setTag(body)
    body.setTag(div)
    println(html)


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
