package com.example.navigationktex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //처음 코드가 실행되면 버튼을 눌러야겠지
        btn_navi.setOnClickListener {
            layout_drawer.openDrawer(GravityCompat.START)
        }
        //
        naviView.setNavigationItemSelectedListener(this)

    }
//다음 페이지로 연결하기
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.access -> Toast.makeText(applicationContext,"접근성",Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext,"이메일",Toast.LENGTH_SHORT).show()
            R.id.send -> Toast.makeText(applicationContext,"송신",Toast.LENGTH_SHORT).show()
        }
        layout_drawer.closeDrawers()
        return false
    }

    override fun onBackPressed() {
        if (layout_drawer.isDrawerOpen(GravityCompat.START))
        {
            layout_drawer.closeDrawers()
        }
        else {
            super.onBackPressed()
        }
    }
}
