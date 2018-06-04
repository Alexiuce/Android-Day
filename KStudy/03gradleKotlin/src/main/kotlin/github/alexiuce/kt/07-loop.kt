package github.alexiuce.kt



/* for 循环可以迭代支持iterator方法的对象
*  while 循环
*  do{}while 循环
*
*  跳出多层循环时,支持使用标签指定break跳出到标签的那一层
*
*
*  xxx@for(){
*     bbb@for(){
*       break@xxx   /* 跳出最外层循环*/
*     }
*  }
* */



class AClass(var iterator: Iterator<String>){

    operator fun next(): String{
        return iterator.next()
    }

    operator fun hasNext():Boolean{
        return iterator.hasNext()
    }
}




fun main(args: Array<String>) {

    for (arg in args){
        println(arg)
    }

    for ((index,value) in args.withIndex()){
        println("index:$index, value: $value")
    }

    val a = AClass(args.iterator())
    for (arg in a.iterator){
        println("arg is $arg")
    }
}