import kotlin.reflect.KProperty


fun main(args: Array<String>) {
    val dd = WFather()
    dd.wash()

    val wb = Brother(dd)
    wb.wash()


    // 属性委托

    val m = Mouse()
    m.money = 70
    println(m.money)
}




interface WashPower{
    fun wash()
}


class WSon: WashPower{
    override fun wash() {
        println("working for washing....")
    }
}



/* 委托: 使用by关键字
*
* */

class WFather: WashPower by WSon()

class Brother(var worker: WashPower): WashPower by worker


/* 属性委托
* 示例: Mouse 的money 属性 由 Desktop 负责存取
* */

class Mouse{
    var money: Int by Desktop()
}


class Desktop{
    operator fun getValue(mouse: Mouse, property: KProperty<*>): Int {
        return outMoney
    }

    operator fun setValue(mouse: Mouse, property: KProperty<*>, i: Int) {
        inMoney += 50
        outMoney += i - 50
    }


    var outMoney = 0
    var inMoney = 0
}

