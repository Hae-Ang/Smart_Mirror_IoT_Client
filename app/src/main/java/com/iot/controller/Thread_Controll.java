package com.iot.controller;

import android.os.Handler;
import android.os.Message;

public class Thread_Controll extends Thread {

    private Handler handler;

    public Thread_Controll(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            Message msg = new Message();

            // 지연시간
            Thread.sleep(2000);
            // 보낼 키워드
            msg.what = 1;
            handler.sendEmptyMessage(msg.what);
        } catch (Exception e) {
            System.out.println("스레드 문제발생");
//            e.printStackTrace();
        }
    }
}
