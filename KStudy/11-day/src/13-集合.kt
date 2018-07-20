fun main(args: Array<String>) {

/* 可变集合*/
    val l1 = mutableListOf("li","zhang","wang")

    l1.add("zhaoa")
    l1.set(1,"jing")
    l1.forEach {
        println(it)
    }

    // listof 集合不能添加和修改元素
    var bs = listOf("a1","a2","a3")

    bs.forEach {
        println(it)
    }


    // Set 集合: 元素不会重复 定以后不能修改和添加
    // MutableSet: 可写,可修改

    val set1 = setOf("gyy","lqx","gyy","fbb","lbb")
    set1.forEach { println(it) }

    println("====== mutableSet 支持修改和添加元素 ========")
    val set2 = mutableSetOf("gyy","lbb")
    set2.add("fbb")
    set2.forEach { println(it) }
    println("=======Tree Set 有序set =======")
   

}


/* HashTable : 线程安全
* HashMap: 线程不安全
* */