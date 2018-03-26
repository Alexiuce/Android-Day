package github.alexiuce

import kotlin.properties.Delegates

/**
 * Created by Alexcai on 2018/3/11.
 */

class Player{
    private var state: PlayState by Delegates.observable(PlayState.IDEA,{ prop,old,new ->
        println("$old --> $new")
        onPlayerStateChangedListener?.onStateChanged(old,new)
    })
    private fun sendCmd(cmd: PlayerCmd){
        when (cmd) {
            is PlayerCmd.Play -> {
                println("playing")
                state = PlayState.PLAYING
            }
            is PlayerCmd.Pause -> {
                println("pause ....")
                state = PlayState.STOP
            }
            is PlayerCmd.Stop -> {
                println("stop....")
                state = PlayState.STOP
            }
            is PlayerCmd.Resume -> {
                println("resume.....")
                state = PlayState.PLAYING
            }
            is PlayerCmd.Seek -> {
                println("seek......")
                state = PlayState.PLAYING
            }
        }
    }
    // region api
    interface OnPlayerStateChangedListener{
        fun onStateChanged(oldState: PlayState, newState: PlayState)
    }
    var onPlayerStateChangedListener: OnPlayerStateChangedListener? = null

    fun play(url: String, position: Long){
        sendCmd(PlayerCmd.Play(url,position))
    }
    fun resume(){
        sendCmd(PlayerCmd.Resume)
    }
    fun pause(){
        sendCmd(PlayerCmd.Pause)
    }
    fun stop(){
        sendCmd(PlayerCmd.Stop)
    }
    fun seekTo(position: Long){
        sendCmd(PlayerCmd.Seek(position))
    }
    // end region
}