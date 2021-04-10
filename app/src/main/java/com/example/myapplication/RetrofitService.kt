package com.example.myapplication

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET("json/students/") //어노테이션
    fun getStudentList(): Call<ArrayList<PersonFromServer>>
    // 해당주소에 get요청을하는데 response가 뒤에 타입이다.


    @POST("json/students/")
    fun createStudent(
        @Body params: HashMap<String, Any>
    ): Call<PersonFromServer>


    //라이브러리사용
    @POST("json/students/")
    fun createStudentEasy(
        @Body params: PersonFromServer
    ): Call<PersonFromServer>

    //로그인
    @POST("user/signup")
    @FormUrlEncoded
    fun register(
        @Field("username") username: String,
        @Field("userpw1") pw1: String,
        @Field("userpw2") pw2: String
    ): Call<User> // 응답

    @POST("user/login")
    @FormUrlEncoded
    fun login(
        @Field("username") username: String,
        @Field("userpw") pw: String
    ): Call<User>

    @GET("instagram/post/list/all/")
    fun getAllPosts():Call<ArrayList<Post>>

    //API 만들기
    @Multipart
    @POST("instagram/post/")
    fun uploadPost(
        @Part image : MultipartBody.Part,
        @Part ("content")requestBody: RequestBody
    ):Call<Post>

    @GET("instagram/post/list")
    fun getUserPostList():Call<ArrayList<Post>>

    @GET("youtube/list/")
    fun getYoutubeList():Call<ArrayList<Youtube>>

    @GET("mellon/list/")
    fun getSongList():Call<ArrayList<Song>>
}