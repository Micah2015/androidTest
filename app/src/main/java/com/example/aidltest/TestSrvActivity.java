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

import com.example.libtestsrv.IMySrvInterface;
import com.example.libtestsrv.MyService;

public class TestSrvActivity extends AppCompatActivity {
    private IMySrvInterface mService;
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = IMySrvInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_srv);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final Intent in = new Intent(this, MyService.class);
        bindService(in, mConnection, BIND_AUTO_CREATE);
    }


    public void testOnClick(View view) {
        if (mService != null) {
            try {
                Toast.makeText(this, mService.getOne().dump(), Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
