package com.alap.appservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        starListenCall();
                stopListenCall();
    }

    public void starListenCall() {
        startService(new Intent(this, PhoneService.class));
    }

    public void stopListenCall() {
        stopService(new Intent(this, PhoneService.class));

    }
}