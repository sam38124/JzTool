package com.example.jztool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.jzandroidwidget.Callback.runner
import com.example.jzandroidwidget.JzTool

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a=0
        findViewById<Button>(R.id.button2).setOnClickListener {
            JzTool.newInstance.runTaskTimer("$a",0.01, runner{
                Log.e("runner","run")
            })
        }
    }
}
