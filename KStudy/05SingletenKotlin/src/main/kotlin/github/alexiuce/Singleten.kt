package github.alexiuce

/**
 * Created by caijinzhu on 2018/3/12.
 */


/** 单利方式1 : 类加载的时候就会创建单利*/
object Singleten{}

/** 单利方式2: 懒加载方式(非线程安全)*/

class Single2{
    /* 使用伴生类 属性 */
    companion object {
        val instance by lazy(LazyThreadSafetyMode.NONE){
            Single2()
        }
    }

    /* 等价写法 */

    private var instance2: Single2? = null
    fun get():Single2 {
        if (instance2 == null){
            instance2 = Single2()

            var temp: Int? = null
            println(temp!!)

        }
        return instance2!!
    }
}


/** 单利方式3: 线程安全(同步锁),每次访问都会加锁*/
class Singleten3 private constructor(){
    companion object {
        private var instance: Single2? = null
    }

    @Synchronized
    fun get(): Single2 {
        if (instance == null){
            instance = Single2()
        }
        return  instance!!
    }
}

/** 单利方式4 : 线程安全*/
class Singleten4 private constructor(){
    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED){
            Singleten4()
        }
    }


    // 等价写法

    private var instance: Singleten4? = null
    fun getInstance(): Singleten4 {
        if (instance == null){

            synchronized(this){
                if (instance == null){
                    instance = Singleten4()
                }
            }
        }
        return  instance!!
    }

}


/** 单利方式5 : 私有内部类 */
class Singleten5 private  constructor(){
    companion object {
        fun getInstance() = InnerObject.instance
    }

    private object InnerObject{
        val instance = Singleten5()
    }
}