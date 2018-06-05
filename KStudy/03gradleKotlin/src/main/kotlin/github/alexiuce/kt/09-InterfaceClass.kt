package github.alexiuce.kt



class XComputer{
    fun addUSBInputDevice(device: XCInputDevice){
        println("add USBinpute device $device")
    }
    fun addBLEInputDevice(device: XCInputDevice){
        println("add BLEinpute device $device")

    }

    fun addInputDevice(device: XCInputDevice){
        when(device){
            is USBInputDevice -> addUSBInputDevice(device)
            is BLEInputDevice -> addBLEInputDevice(device)
            else -> throw  IllegalArgumentException("not support device ...")
        }
    }
}

/* 抽象类: 介于接口与类之间的一种数据结构
* 与接口的区别是: 抽象类通常用来表示是什么,接口则表示有怎样的能力
* 抽象类可以有状态,接口无状态
* 抽象类可以有方法实现,接头只能有无状态的默认实现
* 抽象类只能单继承, 接口可以多实现
* 在类前使用关键字: abstract
* */
abstract class USBMouse(open var name: String): USBInputDevice{
    override fun input(event: Any) {

    }

    override fun toString(): String {
        return name
    }

}


class MagicMouse(override var name: String): USBMouse(name){

    fun light(){

    }
}



fun main(args: Array<String>) {

    val computer = XComputer()
    val mouse = MagicMouse("apple")
    computer.addInputDevice(mouse)

}