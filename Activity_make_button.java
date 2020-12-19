package com.example.korani;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button btn2 =findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubActivity.this,MainActivity.class);
                intent.putExtra("키","위");
                startActivity(intent);
            }
        });

    }

    public void Btn1Click(View v) {
        Toast toast = Toast.makeTexat(this,"ㅋㅋ",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.END|Gravity.BOTTOM,10,10);
        toast.show();
    }
}
