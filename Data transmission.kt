package com.example.intent3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    btn_page.setOnClickListener{
        val intent=Intent(this,SubActivity::class.java)
        intent.putExtra("msg",tv_sendMsg.text.toString())   //tv_sendMsg의 메세지를 담은 뒤 msg라는 키로 잠굼
        startActivity(intent)
    }

    }
}
