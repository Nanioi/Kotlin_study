package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Fragmenttwo : Fragment1() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle","onCreateView")
        // fragment가 인터페이스를 처음으로 그릴 때 호출된다.
        // inflater - 뷰를 그려주는 역할
        // container - 부모 뷰 ( 달라붙을 곳 )

        return inflater.inflate(R.layout.fragment_two,container,false)
    }
}