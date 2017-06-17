package com.decurd.androidfunctionsourcelist.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.decurd.androidfunctionsourcelist.R;
import com.decurd.androidfunctionsourcelist.receiver.MyLocalReceiver;

public class BroadcastReceiverActivity extends AppCompatActivity {

    private BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mReceiver = new MyLocalReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction("MY_ACTION");

        // 리시버등록
        registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // 리시버해제
        unregisterReceiver(mReceiver);
    }

    public void onClick(View view) {
        // 나만의 액션 쏘기
        Intent intent = new Intent("MY_ACTION");
        sendBroadcast(intent);
    }
}
