/* DSL: 领域特定语言
* 1. 扩展函数
* 2. 中缀调用
* 3. 带接收者的函数字面值
* 4. 高阶函数(lambda表达式)
* */



fun main(args: Array<String>) {
    val addr = DAddress("深圳","深南大道",23)
    val person = DPerson("关之琳",30,addr)

    /*1. 使用DSL方式实现上面的效果 */

    val dsl = person {

    }
    println(dsl)

}


fun person(block: ()->Unit): DPerson{
    val p = DPerson()

    return p
}


// 地址信息
data class DAddress(var city: String, var street: String, var number: Int)
// 人物信息
data class DPerson(var name: String = "", var age: Int = 0, var address: DAddress? = null )