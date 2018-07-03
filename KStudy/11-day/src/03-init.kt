/* 构造方法 */

class Son( name: String,  age: Int){
    var name = ""
    var age = 0
    var phone = ""
     /* 构造方法 */
    init {

        this.name = name
        this.age = age
    }

    /* 次构造方法 */
    constructor(name: String, age: Int,  phone: String): this(name,age){
        this.phone = phone
    }
}





fun main(args: Array<String>) {

    val p1 = Son("job", 20)
    println(p1.name)
}