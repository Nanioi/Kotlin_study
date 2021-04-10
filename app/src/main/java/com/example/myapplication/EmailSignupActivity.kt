package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_email_signup.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmailSignupActivity : AppCompatActivity() {

    lateinit var usernameView: EditText
    lateinit var userPW1View: EditText
    lateinit var userPW2View: EditText
    lateinit var registerBtn : TextView
    lateinit var loginBtn : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if((application as MasterApplication).checkIsLogin()){
            finish() // 이 엑티비티 종료
            startActivity(
                Intent(this,InstagramPostListActivity::class.java)
            )
        }else{
            setContentView(R.layout.activity_email_signup)

            initView(this@EmailSignupActivity)
            setupListener(this)
        }
    }
    fun setupListener(activity: Activity){
        registerBtn.setOnClickListener{
            register(this@EmailSignupActivity)
        }
        loginBtn.setOnClickListener{
            startActivity(
                Intent(this@EmailSignupActivity,LoginActivity::class.java)
            )//loginacticity로 이동
        }
    }
    fun register(activity: Activity){
        val username = getUserName()
        val pw1 = getPW1()
        val pw2 = getPW2()

        (application as MasterApplication).service.register(username,pw1, pw2).enqueue(object :
            Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    Toast.makeText(activity,"가입에 성공 하였습니다. ",Toast.LENGTH_LONG).show()
                    val user = response.body()
                    val token = user!!.token!!
                    saveUserToken(token,activity)
                    (application as MasterApplication).createRetrofit()
                    activity.startActivity(
                        Intent(activity,InstagramPostListActivity::class.java)
                    )
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(activity,"가입에 실패 하였습니다. ",Toast.LENGTH_LONG).show()
            }
        })
    }
    fun saveUserToken(token: String,activity: Activity){
        val sp = activity.getSharedPreferences("login_sp",Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp",token)
        editor.commit()
    }

    fun initView(activity: Activity){
        usernameView = activity.findViewById(R.id.username_inputbox)
        userPW1View = activity.findViewById(R.id.pw1_inputbox)
        userPW2View = activity.findViewById(R.id.pw2_inputbox)
        registerBtn = activity.findViewById(R.id.register)
        loginBtn = activity.findViewById(R.id.loginbtn)
    }
    fun getUserName():String{
        return usernameView.text.toString()
    }
    fun getPW1():String{
        return userPW1View.text.toString()

    }
    fun getPW2():String{
        return userPW2View.text.toString()

    }
}