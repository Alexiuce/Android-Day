package github.alexiuce.kt

interface XCInputDevice {

    fun input(event: Any)


}


interface USBInputDevice: XCInputDevice{

}

interface BLEInputDevice: XCInputDevice

