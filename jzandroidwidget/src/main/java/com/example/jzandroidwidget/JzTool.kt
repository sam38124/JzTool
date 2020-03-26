package com.example.jzandroidwidget

import android.app.Activity
import com.example.jzandroidwidget.Callback.callback
import com.example.jzandroidwidget.Callback.runner

class JzTool  {
companion object{
    var tool:JzTool? = null
    val newInstance:callback
    get(){
        if(tool==null){tool=JzTool()}
        return  tool!!.callback
    }

}
    var callback=object :callback{
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
        override fun runTaskTimer(tag: String,time:Double, callback: runner) {

            for(i in runnerTimer){
                if(i.tag==tag){
                    if(i.timer.stop()<time){return}
                    }
            }
            val seq= (runnerTimer).filter { it.tag!=tag }
            runnerTimer= ArrayList(seq)
            val timertask=TimerTask()
            timertask.tag=tag
            timertask.timer=timer()
            runnerTimer.add(timertask)
            callback.run()
        }
    }
    var runtag=ArrayList<String>()
    var runnerTimer=ArrayList<TimerTask>()

}