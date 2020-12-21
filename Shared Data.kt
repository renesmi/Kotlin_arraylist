package com.example.shareddatakt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {      //해당 액티비티가 처음 실행될 때 한번 수행하는 곳(초기화)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //저장된 데이터 로드
        loadData()      //edit text 저장되어 있던 값을 setText
    }
    //2)
    private fun loadData() {
        val pref = getSharedPreferences("pref",0)
        et_hello.setText(pref.getString("name","")) //첫번째 인자에서는 키 값을 적어주고, 두번째는 키 값의 데이터가 존재하지 않을 경우 대체값을 적어준다.
    }
        //1)
    private fun saveData() {
        val pref = getSharedPreferences("pref",0)
        val edit =pref.edit()       //수정모드
        edit.putString("name",et_hello.text.toString())            //put넣는다. String 형태로 ,1번쨰 인자에는 키값 2번째 인자에는 실제 담아둘 값
        edit.apply()        //값을 저장 완료
    }
    override fun onDestroy() {          //액티비티가 종료되는 시점이 다가올 때 호출
        super.onDestroy()
        saveData()
    }
}
