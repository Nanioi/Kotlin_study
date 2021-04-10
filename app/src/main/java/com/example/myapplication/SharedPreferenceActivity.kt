package com.example.myapplication

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)


        //SharedPreference에 저장하는 방법
       //SharedPreference 생성
        //val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)

        //Mode
        //  - MODE_PRIVATE : 생성한 application에서만 사용가능
        //  - MODE_WORLD_READABLE : 다른 application 사용가능 -> 읽기만 가능
        //  - MODE_WORLD_WRITABLE : 다른 application 사용가능 -> 기록도 가능
        //  - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        //  - MODE_APPEND : 기존 preference에 신규로 추가

        // Sharedpreference에 데이터 넣기(저장)
        // sharedPreference에서 edit 얻어와 editor를 통해 데이터 넣어주기
//        val editor : SharedPreferences.Editor = sharedPreference.edit()
//        editor.putString("hello","안녕하세요")
//        editor.commit()

        // sq1 -> SharedPreference
        //         (key,value) -> ("hello","안녕하세요")
        // sq2 -> SharedPreference
        //         (key,value) -> ("hello","안녕하세요11")

        load_button.setOnClickListener{
            // SharedPreference에 값을 불러오는 방법
            val sharedPreference = getSharedPreferences("sql", MODE_PRIVATE)
            val value1 = sharedPreference.getString("helllo","데이터 없음1")
            val value2 = sharedPreference.getString("bye","데이터 없음2")
            Log.d("key-Value","Value 1 : " + value1)
            Log.d("key-Value","Value 2 : " + value2)
        }

        save_button.setOnClickListener{
            val sharedPreference = getSharedPreferences("sql", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("hello","안녕하세요")
            editor.putString("bye","잘가")
            editor.commit()
        }

        delete_button.setOnClickListener{
            val sharedPreference = getSharedPreferences("sql", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.remove("hello")
            editor.commit()
        }
        delete_all_button.setOnClickListener{
            val sharedPreference = getSharedPreferences("sql", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.clear()
            editor.commit()
        }
    }
}