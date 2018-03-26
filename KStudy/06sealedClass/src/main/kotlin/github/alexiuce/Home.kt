package github.alexiuce

/**
 * Created by Alexcai on 2018/3/11.
 */

class PlayDelegate: Player.OnPlayerStateChangedListener{
    override fun onStateChanged(oldState: PlayState, newState: PlayState) {
        println("delegate changed...")
        println("old $oldState, new $newState")
    }
}


fun main(args: Array<String>) {

    val play = Player()
    play.onPlayerStateChangedListener = PlayDelegate()
    play.play("i will be back..",0)
    play.pause()
    play.resume()
    play.seekTo(300)
    play.stop()

}