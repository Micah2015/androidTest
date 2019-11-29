package com.example.aidltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Toast;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private IMyAidlInterface mService;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final Intent in = new Intent();
        in.setClassName(this, "com.example.aidltest.MyAidlService");
        in.setPackage("com.example.aidltest");
        in.setAction("com.example.aidltest.MyAidlService");
        bindService(in, mConnection, BIND_AUTO_CREATE);
    }

    public void click(View view) {
        if (mService != null) {
            try {
                Student stu = mService.getStudent();
                Toast.makeText(MainActivity.this, JniTest.getString(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, "Name: " + stu.getName() + ", " + "age: " + Integer.toString(stu.getAge()), Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
