package com.example.libtestsrv;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.Random;

public class MyService extends Service {

    private static MyBinder instance = null;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        if(instance == null) {
            synchronized (MyBinder.class) {
                if(instance == null) {
                    instance = new MyBinder();
                }
            }
        }
        return instance;
    }

    class MyBinder extends IMySrvInterface.Stub {

        @Override
        public Person getOne() throws RemoteException {
            int age = new Random().nextInt() % 100 + 3;
            return new Person("David", age);
        }
    }
}
