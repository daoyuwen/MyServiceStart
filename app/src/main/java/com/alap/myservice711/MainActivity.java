package com.alap.myservice711;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 1.startService（intent）
 * 第一次调用：-->构造方法——>onCreate()-->onStartService()
 * 在调用的话 -->onStartService()
 *
 * 2.bindService(intent,serviceConnection)
 * 调用：-->构造方法（）--》onCreate（）--》onBind（）--》onServiceConnected（）
 * unbindService（）：（中有当前Activity与Service连接）--》onUnbind（）--》onDestroy（）
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "M";
    private Button mButton;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private ServiceConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        startMyService();
        bindMyService();
        unbindMyService();
        stopMyService();
    }

    private void initView() {
        mButton = findViewById(R.id.button);
        mButton2 = findViewById(R.id.button2);
        mButton3 = findViewById(R.id.button3);
        mButton4 = findViewById(R.id.button4);
    }

    private void startMyService() {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
        Log.e(TAG, "startMyService: 开启了" );
    }

    private void stopMyService() {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
        Log.e(TAG, "stopMyService: 结束了" );
    }

    private void bindMyService() {
        Intent intent = new Intent(this, MyService.class);
        //创建连接对象
        if (null == connection) {
            connection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {

                }

                @Override
                public void onServiceDisconnected(ComponentName name) {

                }
            };
            //BIND_AUTO_CREATE创建以后自动绑定
            bindService(intent, connection, Context.BIND_AUTO_CREATE);
            Log.e(TAG, "bindMyService: 绑定了" );
        } else {
            Log.e(TAG, "bindMyService: 已经绑定了");
        }

    }

    private void unbindMyService() {
        if (connection != null) {
    unbindService(connection);
    connection=null;
            Log.e(TAG, "unbindMyService: 还没绑定" );
        }
    }

}