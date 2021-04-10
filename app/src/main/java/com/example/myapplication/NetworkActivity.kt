package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_network.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkTask(
            recycler_person,
            LayoutInflater.from(this@NetworkActivity)
        ).execute()
    }
}
// url 을 이용해 서버와 직접 통신하는 방법
class NetworkTask(
    val recyclerView: RecyclerView,
    val inflater: LayoutInflater
): AsyncTask<Any?, Any?, Array<PersonFromServer>>(){

    override fun onPostExecute(result: Array<PersonFromServer>) { //MainThread에서 실행 ,UI쓰레드에 접근 가능하므로 여기에서 뷰를 그려줘야함,recyclerview 그려주기
        val adapter = PersonAdapter(result!!,inflater)
        recyclerView.adapter = adapter
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg params: Any?): Array<PersonFromServer> { // 다른 Thread에서 실행 , 네트워크는 메인 X 비동기로 Async 실행
        val urlString : String = "http://mellowcode.org/json/students/"
        val url : URL = URL(urlString)
        val connection : HttpURLConnection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type","application/json")
        // 보내는 요청이 get이다.

        var buffer =""
        if(connection.responseCode == HttpURLConnection.HTTP_OK){
//            Log.d("connn","inputStream" + connection.inputStream)
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()  // string 응답받은거  만든거
//            Log.d("connn","inputStream" + buffer)

        }
        val data = Gson().fromJson(buffer,Array<PersonFromServer>::class.java)

//        val age = data[0].age
//        Log.d("connn","age" + age)

        return data
    }
}
class PersonAdapter(
    val personList : Array<PersonFromServer>,
    val inflater : LayoutInflater
):RecyclerView.Adapter<PersonAdapter.ViewHolder>(){
    inner class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val name : TextView
        val age : TextView
        val intro : TextView
        init{
            name = itemView.findViewById(R.id.person_name)
            age = itemView.findViewById(R.id.person_age)
            intro = itemView.findViewById(R.id.person_intro)

        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.person_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(personList.get(position).name)
        holder.age.setText(personList.get(position).age.toString())
        holder.intro.setText(personList.get(position).intro)

    }
}