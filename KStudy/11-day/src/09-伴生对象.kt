fun main(args: Array<String>) {


    println(BSPerson.name)
}





class BSPerson{
    var age = 19


    companion object {
        var name = "alex"

    }
}

/**  伴生对象
 * 1. 控制属性的静态或非静态
 *
 * */


/** 单利 */

class BSUtils private constructor(){

    companion object {
        val instance: BSUtils by lazy { BSUtils() }
    }

}