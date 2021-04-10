package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one.*

open class Fragment1:Fragment(){

    interface OnDataPassListener{
        fun onDataPass(data:String?)
    }

    lateinit var dataPassListener: OnDataPassListener

    override fun onAttach(context: Context) {

        Log.d("life_cycle","onAttach")
        super.onAttach(context)
        dataPassListener = context as OnDataPassListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cycle","onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle","onCreateView")
        // fragment가 인터페이스를 처음으로 그릴 때 호출된다.
        // inflater - 뷰를 그려주는 역할
        // container - 부모 뷰 ( 달라붙을 곳 )

        return inflater.inflate(R.layout.fragment_one,container,false)
    }

    // Activity의 Oncreate에서 했던 작업을 여기에서 한다.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle","onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        pass.setOnClickListener{
            dataPassListener.onDataPass("Good bye")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle","onActivityCreated")
        super.onActivityCreated(savedInstanceState)

        val data = arguments?.getString("hello")
        Log.d("data", data.toString())
    }

    override fun onStart() {
        Log.d("life_cycle","onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle","onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cycle","onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cycle","onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("life_cycle","onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("life_cycle","onDetach")
        super.onDetach()
    }
}