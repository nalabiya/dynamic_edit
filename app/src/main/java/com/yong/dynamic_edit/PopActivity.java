package com.yong.dynamic_edit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PopActivity extends AppCompatActivity {

    TextView textView1;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        setTitle("동적 EditText 연습 - 팝업 넘어온값 조회");

        textView1 = findViewById(R.id.textView1);
        button1 = findViewById(R.id.button1);

        Intent intent = getIntent();
        int num = intent.getIntExtra("num",0);
        ArrayList<String> strList = intent.getStringArrayListExtra("strList");

        StringBuffer sb = new StringBuffer();
        for (int i=0;i<strList.size();i++) {
            sb.append(strList.get(i).toString() + "\r\n");
        }

        textView1.setText(sb);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
