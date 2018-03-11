package github.alexiuce

/**
 * Created by Alexcai on 2018/3/11.
 */

sealed class PlayerCmd{
    class Play(val url: String, val position: Long = 0): PlayerCmd()
    class Seek(val position: Long): PlayerCmd()
    object Pause: PlayerCmd()
    object Resume: PlayerCmd()
    object Stop: PlayerCmd()

}