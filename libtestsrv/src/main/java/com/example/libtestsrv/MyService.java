package com.example.libtestsrv;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.Random;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    class MyBinder extends IMySrvInterface.Stub {

        @Override
        public Person getOne() throws RemoteException {
            int age = new Random().nextInt() % 100 + 3;
            return new Person("David", age);
        }
    }
}
