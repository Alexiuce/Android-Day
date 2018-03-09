package github.alexiuce

/**
 * Created by caijinzhu on 2018/3/9.
 */



enum class Lang(val hello: String){
    ENGLISH("hello"),
    CHINESE("你好"),
    JAPANESE("こんにちは"),
    KOREAN("안녕하세요");

    fun sayHello(){
        println(hello)
    }
    /* 与java 静态方法相似 */
    companion object {
        fun parse(name: String): Lang {
            return Lang.valueOf(name.toUpperCase())
        }
    }
}


fun main(args: Array<String>) {
    if (args.isEmpty()) return
    val lang = Lang.parse(args[0])
    println(lang)
    lang.sayHello()
    lang.sayBye()


    arrayOf("a","b","c","d").forEach { println(it) }
}

fun Lang.sayBye(){
    val bye = when(this){
        Lang.CHINESE -> "再见"
        Lang.ENGLISH -> "bye"
        Lang.JAPANESE -> "こんに"
        Lang.KOREAN -> "하세"
    }
    println(bye)
}