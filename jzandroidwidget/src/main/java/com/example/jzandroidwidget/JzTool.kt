package com.example.jzandroidwidget

import android.app.Activity
import com.example.jzandroidwidget.Callback.callback
import com.example.jzandroidwidget.Callback.runner

class JzTool : callback {
companion object{
    var tool:JzTool? = null
    val newInstance:JzTool
    get(){
        if(tool==null){tool=JzTool()}
        return  tool!!
    }

}
    var runtag=ArrayList<String>()
    var runnerTimer=ArrayList<TimerTask>()
    override fun timer(): JzClock {
        return JzClock()
    }
    override fun checkBattery(activity: Activity): Boolean {
        return CheckBattery.CheckIsCharage(activity)
    }

    override fun runTaskOnce(tag: String, callback: runner) {
        if(runtag.contains(tag)){return}else{
            runtag.add(tag)
            callback.run()
            runtag.remove(tag)
        }
    }
    override fun runTaskTimer(tag: String,time:Long, callback: runner) {
       for(i in runnerTimer){
           if(i.tag==tag&&i.timer.stop()<time){return}
       }
        val timertask=TimerTask()
        timertask.tag=tag
        timertask.timer=timer()
        callback.run()
        runnerTimer.remove(timertask)
    }
}