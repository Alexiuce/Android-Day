
/* kotlin 操作符
*
* 每个运算符都是对用方法的简写方式
*
* 一元操作符
+a	a.unaryPlus()
-a	a.unaryMinus()
!a	a.not()
*当编译器处理例如表达式 +a 时，它执行以下步骤：

确定 a 的类型，令其为 T；
为接收者 T 查找一个带有 operator 修饰符的无参函数 unaryPlus（），即成员函数或扩展函数；
如果函数不存在或不明确，则导致编译错误；
如果函数存在且其返回类型为 R，那就表达式 +a 具有类型 R；
*
*
* 二元操作符
a + b	a.plus(b)
a - b	a.minus(b)
a * b	a.times(b)
a / b	a.div(b)
a % b	a.rem(b)、 a.mod(b) （已弃用）//自 Kotlin 1.1 起支持 rem 运算符。Kotlin 1.0 使用 mod 运算符，它在 Kotlin 1.1 中被弃用。
a..b	a.rangeTo(b)
*
* 重载运算符: 官网说明 https://www.kotlincn.net/docs/reference/operator-overloading.html
*
* 1. 找到对应的函数
* 2. 添加operator 关键字
*
* */



class Girl{
    var name = "mary"
    var age = 10

   operator fun plus(g: Girl): Girl{
        return this
    }
}

fun main(args: Array<String>) {

    val g1 = Girl()
    println(g1)
    g1.name = "hurry"
    val g2 = Girl()
    println(g1 + g2)

}