package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView

import android.widget.TextView
import com.example.myapplication.R.layout.activity_listener
import org.w3c.dom.Text


class Listener : AppCompatActivity() {

    var num = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_listener)

        // 뷰를 activity로 가져오는 방법1
//        // 직접 찾아서 가져오기
        val textView: TextView = findViewById(R.id.hello)
        val imageView : ImageView = findViewById(R.id.image)
        // 방법2
        // xml을 import해서 가져오기
//        hello.

        //람다방식
        textView.setOnClickListener {
            Log.d("click", "Click!")

        }

        //익명함수 방식
        textView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click", "Click!")
            }
        })

        // ==  ( click이라는 이름이 필요한 경우 )
        val click = object :View.OnClickListener{
            override fun onClick(v: View?) {
                textView.setText("안녕하세요")
                imageView.setImageResource(R.drawable.nani)
                num+=10
                Log.d("number",""+num)
            }
        }
        textView.setOnClickListener(click)
        //뷰를 조작하는 함수들
        // setText, setImageResource

    }
}