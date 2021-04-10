package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_mytube_detail.*

class MytubeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mytube_detail)


        val url = intent.getStringExtra("video_url")
        //영상재생
        val mediaController = MediaController(this@MytubeDetailActivity)
        video_view.setVideoPath(url)
        video_view.requestFocus()
        video_view.start()
        mediaController.show()

        //영상 멈춤, 가로기능 등 부가기능 만들어보기

        //영상을 전문적으로 다룰때 사용할거
        //Exoplayer > mediaController
        //drm -> digital right management
        //안드로이드 좀 익힌 후 만들기 

    }
}