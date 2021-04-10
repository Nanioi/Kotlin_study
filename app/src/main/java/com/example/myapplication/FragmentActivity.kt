package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentManager

class FragmentActivity : AppCompatActivity() , Fragment1.OnDataPassListener {

    override fun onDataPass(data: String?) {
        Log.d("pass",""+data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle","onCreate")
        val button: Button = findViewById(R.id.button)
        val button2: Button = findViewById(R.id.button2)

        val fragment1  : Fragment1 = Fragment1() // fragment 생성
        // 프라그먼트에 data를 넣어주는 방법
        val bundle:Bundle= Bundle()
        bundle.putString("hello","hello")
        fragment1.arguments = bundle

        button.setOnClickListener{
            //fragment를 동적으로 작동하는 방법
            val fragmentManager :FragmentManager = supportFragmentManager

            //Transaction
            //작업의 단위 -> 시작과 끝이 있다.
            val fragmentTransaction = fragmentManager.beginTransaction() // 시작
            fragmentTransaction.replace(R.id.container,fragment1) // 할일 //프라그먼트 붙이는 방법 ( replace/add ) , 둘은 동일
            fragmentTransaction.commit() // 끝

            //끝을 내는 방법
            //commit -> 시간될때 해( 좀더 안정적)
            //commitnow -> 지금당장해
        }
        button2.setOnClickListener {
            val fragmentManager :FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.detach(fragment1)
            fragmentTransaction.commit()

            //프라그먼트 remove/detach하는 방법
            //remove - 다시 붙이려할때 다시 붙일 수 있음
            //detach - 다시 붙일 수 없
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("life_cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle","onDestroy")
    }
}