import java.lang.StringBuilder

fun main(args: Array<String>) {

    val html = Tag("html")
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



        sb.append("</$name>")

        return sb.toString()
    }
}

class HTML:Tag("Html"){

}