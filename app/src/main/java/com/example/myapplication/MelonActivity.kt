package com.example.myapplication

import android.app.Activity
import android.media.MediaPlayer
import android.net.Uri
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
import kotlinx.android.synthetic.main.activity_mellon.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MelonActivity : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mellon)

        (application as MasterApplication).service.getSongList().enqueue(
            object : Callback<ArrayList<Song>> {
                override fun onResponse(
                    call: Call<ArrayList<Song>>,
                    response: Response<ArrayList<Song>>
                ) {
                    if (response.isSuccessful) {
                        val songList = response.body()
                        val adapter = MelonAdapter(
                            songList!!,
                            LayoutInflater.from(this@MelonActivity),
                            Glide.with(this@MelonActivity),
                            this@MelonActivity
                        )
                        song_list.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<ArrayList<Song>>, t: Throwable) {}
            }
        )
    }

    //앱껏을때 실행종료
    override fun onPause() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        super.onPause()
    }
    inner class MelonAdapter(
        var songList: ArrayList<Song>,
        val inflater: LayoutInflater,
        val glide: RequestManager,
        val activity: Activity
    ) : RecyclerView.Adapter<MelonAdapter.ViewHolder>() {
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val title: TextView
            val thumnail: ImageView
            val play: ImageView

            init {
                title = itemView.findViewById(R.id.song_title)
                thumnail = itemView.findViewById(R.id.song_img)
                play = itemView.findViewById(R.id.song_play)

                play.setOnClickListener {
                    val position: Int = adapterPosition
                    val path = songList.get(position).song

                    //노래 도중 다른노래 틀었을때 기존 재생곡 재생중지
                    try{
                        mediaPlayer?.stop()
                        mediaPlayer?.release()
                        mediaPlayer=null
                        mediaPlayer = MediaPlayer.create(
                            this@MelonActivity,
                            Uri.parse(path)
                        )
                        mediaPlayer?.start()
                    }catch (e:Exception){

                    }
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.song_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.title.setText(songList.get(position).title)
            glide.load(songList.get(position).thumnail).into(holder.thumnail)
        }

        override fun getItemCount(): Int {
            return songList.size
        }
    }
}