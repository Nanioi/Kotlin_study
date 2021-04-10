package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)


        Realm.init(this@RealmActivity)
        // realm 을 초기화할 방식 configration 생성
        // 엑셀( 테이블 )에서 필드 ( 전화번호 ) 추가시 Migration필요
        // deleteRealmIfMigrationNeeded() -> Migtation 필요시 기존에 있던 데이터들을 삭제하겠다. 삭제하고 다시쓰겠다.
        val config : RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)

        //.Builder() -> 위와같이 메서드체이닝이 많이 일어난다.

        //Realm 얻기
        val realm = Realm.getDefaultInstance()

        button_save.setOnClickListener{
            realm.executeTransaction {
                //A테이블에서 데이터를 가져온다.
                //B테이블에서 데이터를 가져온다.
                //C테이블에서 데이터를 가져온다.
                //조합을 한다.
                //D테이블에 저장을 한다. ( 여기까지 하나의 작업단위 )

                with(it.createObject(School::class.java)){
                    this.name = "어떤 대학교"
                    this.location = "서울"
                }
            }
        }
        button_load.setOnClickListener {
            realm.executeTransaction {
                val data = it.where(School::class.java).findFirst()
                Log.d("data","data : "+data)
            }
        }
        button_delete.setOnClickListener {
            realm.executeTransaction {
                it.where(School::class.java).findAll().deleteAllFromRealm()
            }
        }

    }
}