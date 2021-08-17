package com.iot.mirror;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.iot.controller.Thread_Controll;

public class Intro_T extends AppCompatActivity {

//    private ImageView img_View = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        // 상태바 지우기
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        setContentView(R.layout.mirror_intro_t);

//        img_View = findViewById(R.id.img_View);

        Thread_Controll thread_controll = new Thread_Controll(handler);

//        img_View.setVisibility(View.VISIBLE);

        thread_controll.start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                // 실행 후 바로 다른 액티비티 넘어감.
                Intent intent = new Intent(Intro_T.this, Login_T.class);
                startActivity(intent);
            }
        }
    };
}