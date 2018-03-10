package github.alexiuce

/**
 * Created by caijinzhu on 2018/3/9.
 */

/**
a_b_c d_e f_g

 */





fun main(vararg args: String) {

    args.flatMap {
        it.split("_")
    }.map {
        print("$it ")
    }

}