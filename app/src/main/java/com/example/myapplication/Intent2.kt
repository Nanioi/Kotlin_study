package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        val number1 = intent.getIntExtra("number1",0) // 전달된 값이 없거나 맞지 않는경우 0으로 초기화
        val number2 = intent.getIntExtra("number2",0) // 전달된 값 받기
        Log.d("number",""+number1)
        Log.d("number",""+number2)

        val button: Button = findViewById(R.id.result)

        button.setOnClickListener{


            val result = number1 + number2
            val resultIntent = Intent() // 인텐트 만들기
            resultIntent.putExtra("result",result) // 결과 값 리턴
            setResult(RESULT_OK,resultIntent) // 결과값 보내주기 , RESULT_OK = -1
            finish() // Activity종료 , Intent2가 사라지고 남아있는 Intent1이 실행된다. ( 스택 - intent1 위에 intent2 )
         }

    }
}