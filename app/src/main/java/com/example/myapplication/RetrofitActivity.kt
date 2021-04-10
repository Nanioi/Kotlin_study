package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        //GET 요청
        service.getStudentList()
            .enqueue(object : Callback<ArrayList<PersonFromServer>> { // 이 통신을 대기줄에 올려놨다.

                override fun onResponse( // 통신 성공 시 호출
                    call: Call<ArrayList<PersonFromServer>>,
                    response: Response<ArrayList<PersonFromServer>>
                ) {
                    if (response.isSuccessful) {
                        val personList = response.body()
                        Log.d("retrofitt", " age : " + personList?.get(0)?.age)

                        val code = response.code() // 200
                        val error = response.errorBody() // 203/204등 완전한 성공 x
                        val header = response.headers() // 인증정보나 요약본

                    }
                }

                override fun onFailure(
                    call: Call<ArrayList<PersonFromServer>>,
                    t: Throwable
                ) { //통신 실패 시 호출
                    Log.d("retrofitt", "Error") // 보통  에러메세지만 출력


                    call.isCanceled // 취소된건지
                    call.isExecuted // 실행은 된건지
                    call.cancel() // 실패 시 다시시도하지 말고 취소

                }
            })

        //POST 요청(1)
//        val params = HashMap<String, Any>()
//        params.put("name", "곽나연")
//        params.put("age", "24")
//        params.put("intro", "안녕하세요")
//        service.createStudent(params).enqueue(object : Callback<PersonFromServer> {
//            override fun onResponse(
//                call: Call<PersonFromServer>,
//                response: Response<PersonFromServer>
//            ) {
//                if (response.isSuccessful) {
//                    val person = response.body()
//                    Log.d("retrofitt", " name : " + person?.name)
//                }
//            }
//
//            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//            }
//        })

        //POST 요청(2)
        val person = PersonFromServer(name ="김철수",age = 12,intro = "안녕 철수야")
        service.createStudentEasy(person).enqueue(object : Callback<PersonFromServer> {
            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if (response.isSuccessful) {
                    val person = response.body()
                    Log.d("retrofitt", " name : " + person?.name)
                }
            }

            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
            }
        })
    }
}