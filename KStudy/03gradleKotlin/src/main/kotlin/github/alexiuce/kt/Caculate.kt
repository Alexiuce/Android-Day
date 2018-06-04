package github.alexiuce.kt


class Caculate(val op: String){

    var my_func: (Int,Int) -> Int

    init {
        my_func = when(op){
            "+" -> {a,b -> a + b}
            "-" -> {a,b -> a - b}
            "*" -> {a,b -> a * b}
            "/" -> {a,b -> a / b}
            "%" -> {a,b -> a % b}
            else -> throw UnsupportedOperationException(op)

        }
    }

    fun cacl(a: Int, b: Int): Int{
        return my_func(a, b)
    }
}