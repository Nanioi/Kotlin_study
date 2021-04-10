package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val textView: TextView = findViewById(R.id.change_activity)

        textView.setOnClickListener{
            //명시적 인텐트
            val intent = Intent(this@Intent1, Intent2::class.java)

            //Key,Value 방식 -> Dictionary
            intent.putExtra("number1",1)
            intent.putExtra("number2",2)
            startActivity(intent) // 전달만하는


            //위와 동일
            val intent2 = Intent(this@Intent1, Intent2::class.java)
            intent2.apply{
                this.putExtra("number1",1)
                this.putExtra("number2",2)
            }
            //startActivity(intent2)
            startActivityForResult(intent2,200) // 리턴을 받는 요청 , 200이라는 이름으로 intent2엑티비티 보내는 거

            // 암시적 인텐트
            val intent3 = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com")) // ACTION_VIEW => 뒤에것을 보여줘라
            startActivity(intent3)
        }
    }

    //intent 결과값 받기
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==200){
            Log.d("number",""+requestCode) // 보낼때 지정해준 200
            Log.d("number",""+resultCode) // RESULT_OK , -1
            val result = data?.getIntExtra("result",0)
            Log.d("number",""+result)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}