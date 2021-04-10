package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_async.*

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        var task :BackgroundAsyncTask? = null
        start.setOnClickListener {
            task = BackgroundAsyncTask(progressbar,ment)
            task?.execute()
        }
        stop.setOnClickListener {
            task?.cancel(true)
        }
    }
// 다른앱으로 이동하거나 끈경우 async를 종료하려면 따로 만들어줘야하는 단점있음
//    override fun onPause() {
//        task?.cancel(true)
//        super.onPause()
//    }
}

class BackgroundAsyncTask(
    val progressbar :ProgressBar,
    val progressText : TextView
): AsyncTask<Int,Int,Int>(){
    // params -> doInBackground에서 사용할 타입 , 첫번째 타입 string등 가능
    // progress -> onProgressUPdate 에서 사용할 타입
    // result -> onPostExecute에서 사용할 타입

    var percent:Int = 0

    override fun onPreExecute() {
        percent = 0
        progressbar.setProgress(percent)
    }//작업의 시작전

    override fun doInBackground(vararg params: Int?): Int {
        while(isCancelled()== false){ //완료되기전에 취소가 되었는지 아닌지. oncancelled()과 다름
            percent++
            if(percent>100)
                break
            else
                publishProgress(percent)
            try{
                Thread.sleep(100)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        return percent
    }
    //percent가 100인경우 리턴됨

    override fun onProgressUpdate(vararg values: Int?) {
        progressbar.setProgress(values[0] ?: 0) // values가 여러개 가능, 첫번째꺼가 null인경우 0초기화
        progressText.setText("퍼센트 : "+values[0])
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다. ")
    }// doIn에서 리턴한 값이 인자로 들어옴

    override fun onCancelled() {
        progressText.setText("작업이 취소되었습니다. ")
        progressbar.setProgress(0)
    }
}