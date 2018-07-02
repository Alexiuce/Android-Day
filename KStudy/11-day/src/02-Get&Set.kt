
/* kotlin 定义属性后,会默认生成get和set方法
 *
  *
  * */



class Person{
    var name = "alex"
    private set  // 使set方法私有化,外界无法使用set方法
    var age = 0
    set(value) {
        if (value >= 100){
            field = 100
        }
        field = value
    }
}


fun main(args: Array<String>) {
    var p = Person()
//    p.name = "xiuce"   // 这句代码会报错,因为set方法被私有化,无法使用
    p.age = 78
    println(p.age)
    p.age = 200
    println(p.age)

}