package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NullSafety : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

        val number :Int = 10
        val number1 : Int? = null

        val number5:Int=number!!+10 //( 개발자가 number1이 null이 아니라고 보장, 사용 비추 , 나중에 바뀔수 있기떄문 )

        //number + number1?
        val number3 = number1?.plus(number)
        Log.d("number", "number3 :"+number3)

        //삼항연산자 -> 엘비스 연산자
        val number4 = number1  ?: 10 // number1이 null일경우 10이 들어감
    }
    fun plus (a:Int,b:Int?):Int{
        if(b!=null)return a+b
        else return a
    }
    fun plus2(a:Int,b:Int?):Int?{
        return b?.plus(a) // b가 null일경우 b(null)가 반환됨
    }
}