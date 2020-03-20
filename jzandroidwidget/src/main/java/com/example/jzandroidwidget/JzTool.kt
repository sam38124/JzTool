package com.example.jzandroidwidget

import android.app.Activity

class JzTool {
companion object{
    //取得碼表
    fun timer(): JzClock {
        return JzClock()
    }
    //判斷是否有在充電
    fun checkBattery(activity: Activity):Boolean{return CheckBattery.CheckIsCharage(activity)}
}
}