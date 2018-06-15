package github.alexiuce.kt




fun main(args: Array<String>) {
    val place = "浙江省杭州市拱墅区"
    println(place)

    /* 原样输出字符串 */
    val place1 = """
        浙江省
        杭州市
        拱墅区
    """.trimIndent()
    println(place1)

    /* 字符串删除空格 */
    val es = "tom jack      "
    println(es.trim())

    /*删除空格和指定的前缀符号*/
    val es1 = """
        *江西省
        *南昌市
        *西湖区

    """.trimMargin("*")
    println(es1)

    /* 字符串的比较 == === */
    val s1 = "abc"
    val s2 = String(charArrayOf('a','b','c'))
    println(s1.equals(s2))
    println(s1 == s2)
    println(s1 === s2)

    /* 字符串切割 支持多条件切割 */
    val text = "192.168.0.111"
    val result = text.split(".")
    println(result)


    /* 字符串截取 */

    val str = "/User/local/bin/python/file.doc"
    println(str.substring(0, 6))
    println(str.substringAfter("l"))
    println(str.substringAfterLast("n"))


    /* 二元元组 与 三元元组 */
    val p = Pair("Jobs",33)

    println("${p.first}, ${p.second}")
    val p1 = "Tom" to 19   /* 简写 */
    println(p1)

    /* 三元元组 */
    val t = Triple("Bills",30,"new york")
    println(t)


}