package com.yong.dynamic_edit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    LinearLayout ll;
    ArrayList<String> strList;
    int num = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("동적 EditText 연습");

        ll = findViewById(R.id.ll);

        for (int i = 0; i< num; i++) {

            final EditText et = new EditText(getApplicationContext());
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            et.setLayoutParams(p);
            et.setText("editText" + i);
            et.setId(i);
            ll.addView(et);
        }

        strList = new ArrayList<String>();

        Button button3 = findViewById(R.id.button3);

        // 새 팝업창으로 값넘기기
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (num > 0) {

                    for (int i=0;i<num;i++) {
                        EditText et = (EditText) ll.getChildAt(i);
                        strList.add(et.getText().toString());
                    }

                    Intent intent = new Intent(getApplicationContext(), PopActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("num", num);
                    intent.putStringArrayListExtra("strList", strList);
                    startActivity(intent);

                    strList.clear();


                } else {
                    Toast.makeText(getApplicationContext(),"EditText 박스 만들기 버튼을 눌러 박스를 만들어 주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}