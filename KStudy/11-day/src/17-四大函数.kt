fun main(args: Array<String>) {

    val list1 = arrayListOf("感冒药","消炎药","驱蚊药","解毒药")
    /** 1. apply 函数
     * 任意类型都有apply 函数
     * 参数是一个函数: T.()->Unit (带接收者的函数)
     * this代表调用的对象
     * 可以访问对象的方法
     * */
    list1.apply {
        add("感冒灵")
        add("感冒汤")
        add("感冒片")
    }

    println(list1)
    /** 2. let函数
     * 任意类型都有let函数
     * 参数是是一个函数: 函数参数是调用者本身 (T) -> R 返回值就是lambda表达式的返回值
     *
     * */
    list1.let {
        it.add("田七")
    }

    println(list1)

    /** 3. with函数
     * 是独立函数,可以任意地方调用
     * 需要两个参数
     * 第一个参数可以是任意类型
     * 第二个参数是函数: 并且这个函数的参数是带接收者字面量,接收这就是第一个参数
     * with的返回值是第二个函数参数的返回值
     * */

    with(list1){
        add("当归")
    }
    println(list1)
}


