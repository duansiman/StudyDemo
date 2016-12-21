package com.example.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by epdc on 2016/5/15.
 */
public class AidlService extends Service {

    Person person;

    @Override
    public void onCreate() {
        super.onCreate();
        person = new Person("张三", 23);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        MyBinder myBinder = new MyBinder();

        return myBinder;
    }

    class MyBinder extends ICat.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public Person getPerson() throws RemoteException {
            return person;
        }
    }

}
