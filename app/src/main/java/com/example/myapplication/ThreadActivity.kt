package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val runnable:Runnable=object:Runnable{
            override fun run() {
                //쓰레드에서 하고싶은일을 적으면됨
                Log.d("thread-1","Thread is made")
            }
        }
        val thread:Thread=Thread(runnable)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener{
            thread.start()
        }

        Thread(object:Runnable{
            override fun run(){
                Log.d("thread-1","Thread2 is made")
            }
        }).start()
        Thread(Runnable{
            Log.d("thread-1","Thread3 is made")
            Thread.sleep(2000)//1000-1초
            runOnUiThread {
                button.setBackgroundColor(getColor(R.color.textview_color))
            }
        }).start()
    }
}