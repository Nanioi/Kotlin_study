package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_mytube.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MytubeActivity : AppCompatActivity() {

    lateinit var glide:RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mytube)

        (application as MasterApplication).service.getYoutubeList()
            .enqueue(object : Callback<ArrayList<Youtube>>{
                override fun onResponse(
                    call: Call<ArrayList<Youtube>>,
                    response: Response<ArrayList<Youtube>>
                ) {
                    if(response.isSuccessful){
                        glide = Glide.with(this@MytubeActivity)
                        val youtubeList = response.body()
                        val adapter = MytubePostAdapter(
                            youtubeList!!,
                            LayoutInflater.from(this@MytubeActivity),
                            glide,
                            this@MytubeActivity
                        )
                        youtube_list_recycler.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<ArrayList<Youtube>>, t: Throwable) {
                }
            })
    }
}
class MytubePostAdapter(
    var youtubeList : ArrayList<Youtube>,
    val inflater: LayoutInflater,
    val glide: RequestManager,
    val activity:Activity
): RecyclerView.Adapter<MytubePostAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView
        val thumnail : ImageView
        val content : TextView

        init{
            title = itemView.findViewById(R.id.youtube_title)
            thumnail = itemView.findViewById(R.id.youtube_thumnail)
            content = itemView.findViewById(R.id.youtube_content)

            //유튜브 비디오 정보 가져와 넘겨주기
            itemView.setOnClickListener{
                val position : Int = adapterPosition
                val intent = Intent(activity,MytubeDetailActivity::class.java)
                intent.putExtra("video_url",youtubeList.get(position).video)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.youtube_item_view ,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(youtubeList.get(position).title)
        holder.content.setText(youtubeList.get(position).content)
        glide.load(youtubeList.get(position).thumbnail).into(holder.thumnail)
    }

    override fun getItemCount(): Int {
        return youtubeList.size
    }
}