package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import kotlinx.android.synthetic.main.activity_instagram_upload.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class InstagramUploadActivity : AppCompatActivity() {

    lateinit var filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instagram_upload)

        view_pictures.setOnClickListener{
            getPicture()
        }
        upload_text.setOnClickListener{
            uploadPost()
        }
        all_list.setOnClickListener {
            startActivity(Intent(this, InstagramPostListActivity::class.java))
        }
        info.setOnClickListener {
            startActivity(Intent(this, InstagramUserInfo::class.java))
        }
        my_list.setOnClickListener {
            startActivity(Intent(this, InstagramMyPostListActvity::class.java))
        }
    }
    //외부에서 사진가져오기
    fun getPicture(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI) // 외부저장소로 가겠다.
        intent.setType("image/*") // 이미지만 보여지게
        startActivityForResult(intent,1000)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1000){
            val uri : Uri = data!!.data!! // data type - uri, 상대경로
            //uri : 어떤 자료의 위치
            //uri : 웹주소의 위치
            filePath = getImageFilePath(uri)
        }
    }

    //권한주는거 추가하기

    //절대경로 알아내기
    fun getImageFilePath(contentUri: Uri):String{
        var columnIndex = 0
        val projection = arrayOf(MediaStore.Images.Media.DATA) // 걸러내기
        val cursor = contentResolver.query(contentUri,projection,null,null,null)
        // list index 가르키기 , content 관리하는 resolver에 검색(query) 부탁
        if( cursor!!.moveToFirst()){
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        return cursor.getString(columnIndex)
    }
    fun uploadPost(){
        val file = File(filePath)
        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"),file)
        val part = MultipartBody.Part.createFormData("image",file.name,fileRequestBody)
        val content = RequestBody.create(MediaType.parse("text/plain"),getContent())

        (application as MasterApplication).service.uploadPost(
            part,content
        ).enqueue(object:Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if(response.isSuccessful){
                    finish()
                    startActivity(Intent(this@InstagramUploadActivity
                        , InstagramMyPostListActvity::class.java))
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
            }
        })
    }
    fun getContent():String {
        return content_input.text.toString()
    }
}
//1
//2 <-cursor
//3
//4