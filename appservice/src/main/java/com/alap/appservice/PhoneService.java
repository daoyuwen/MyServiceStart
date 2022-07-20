package com.alap.appservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import androidx.annotation.Nullable;

public class PhoneService extends Service {
    private static final String TAG = "P";
    private TelephonyManager tm;
    private PhoneStateListener listener =new PhoneStateListener(){

      public void onCallStateChanged(int state,String incomingNumber){

      }

    };



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //得到电话管理器
        tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        //监听电话状态
        tm.listen();
        Log.e(TAG, "onCreate: " );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }
}
