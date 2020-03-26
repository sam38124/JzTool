package com.example.jzandroidwidget.Callback

import android.app.Activity
import com.example.jzandroidwidget.JzClock

interface callback{
    //取得碼表
    fun timer(): JzClock
    //判斷是否有在充電
    fun checkBattery(activity: Activity):Boolean
    //執行任務處理，並且同時間只能處理一次任務，必須等任務處理完才能進行下次的執行
    fun runTaskOnce(tag:String,callback: runner)
    //執行任務處理，並且必須大於時間間隔
    fun runTaskTimer(tag:String,time:Double, callback: runner);
}