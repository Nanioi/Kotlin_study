package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view_activity.*

  class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_activity)

        val carList = ArrayList<Car>()
        for(i in 0 until 10){
            carList.add(Car(""+i+"번째 자동차",""+i+"순위 엔진"))
        }

        val adapter = ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))
        listView.adapter=adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position)as Car).name
            val carEngine = (adapter.getItem(position)as Car).engine

            Toast.makeText(this@ListViewActivity, carName+""+carEngine, Toast.LENGTH_SHORT).show()
        }
    }
}

class ListViewAdapter(
    val carForList:ArrayList<Car>,
    val layoutInflater:LayoutInflater
) : BaseAdapter(){
    override fun getCount(): Int {
        //그리고자 하는 아이템 리스트의 전체 갯수
        return carForList.size
    }

    override fun getItem(position: Int): Any {
        return carForList.get(position)
    } // 그리고자  하는 아이템 리스트의  하나(포지션에 해당하는)

    override fun getItemId(position: Int): Long {
        return position.toLong()
        // 해당 포지션에 위치해 있는 아이템뷰의 아이디 설정
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val view=layoutInflater.inflate(R.layout.item_view,null)
//        var carNameTextView = view.findViewById<TextView>(R.id.car_name)
//        var carEngineTextView = view.findViewById<TextView>(R.id.car_engine)
//
//        carNameTextView.setText(carForList.get(position).name)
//        carEngineTextView.setText(carForList.get(position).engine)
//
//        return view

        val view:View
        val holder :ViewHolder

        if(convertView==null){
            view=layoutInflater.inflate(R.layout.item_view,null)
            holder= ViewHolder()

            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_engine)

            view.tag = holder
        }else{
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        holder.carName?.setText(carForList.get(position).name)
        holder.carEngine?.setText(carForList.get(position).engine)

        return view
    }
}

class ViewHolder{
    var carName : TextView? = null
    var carEngine : TextView? = null
}