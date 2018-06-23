package github.alexiuce

fun main(args: Array<String>) {

    val str = "this is a good day"

    for (c in str){
        println(c)
    }


    println(str.length)

    for ((k,v) in str.withIndex()){
        println("index: $k, value: $v")
    }



    /* for each 不支持break 和continue */
    str.forEach {
        println(it)

    }
    str.forEachIndexed { index, c: Char ->

        println("index=$index, c = $c")
    }

    /* 多重循环 */
    val str1 = "123456"

    val str2 = "abcdef"
     first@for (c in str1){
        for (c1 in str2 ){
            if (c == '3' && c1 == 'c'){
                break@first
            }
            println("$c == $c1")
        }
    }

}