package com.example.textview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //앱이 최초 실행되었을때 수행.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  //Xml 화면 뷰를 연결한다.

       btn_toast.setOnClickListener {

           iv_profile.setImageResource(R.drawable.seo_05)//이미지 뷰에 새로운 목록
           Toast.makeText(this@MainActivity, "버튼이 클릭 되었습니다. ", Toast.LENGTH_SHORT).show()
       }
       button3.setOnClickListener{                              //버튼.setClickListner{}안에 있는 것들이 실행
        val intent = Intent(this,SubActivity2::class.java)        //val intent선언 은 Intent(넘어갈 액티비티::클래스.java)
           startActivity(intent)                                  // intent 를 실행한다. 


       }
    }



}
