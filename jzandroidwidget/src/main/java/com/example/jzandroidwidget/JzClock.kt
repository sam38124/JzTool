package com.example.jzandroidwidget

import java.text.SimpleDateFormat
import java.util.*

 class JzClock{
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
    var past = sdf.parse(sdf.format(Date()))

    fun Zeroing(){
        past = sdf.parse(sdf.format(Date()))
    }
    fun stop():Long{
        val now = sdf.parse(sdf.format(Date()))
        return getDatePoor(now,past)
    }
    fun getDatePoor(endDate: Date, nowDate: Date): Long {
        val diff = endDate.time - nowDate.time
        val sec = diff / 1000
        return sec
    }
}