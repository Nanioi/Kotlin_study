package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resouse)

        val ment = resources.getString(R.string.hello)
        Log.d("ment","ment :"+ment)

        val ment1 = getString(R.string.hello)
        Log.d("ment","ment1 :"+ment1)

        val color = getColor(R.color.textview_color)
        
    }

}