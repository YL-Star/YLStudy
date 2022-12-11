package com.yl.study.aidl.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.yl.study.IMyAidlInterface;
import com.yl.study.aidl.bean.Student;

import java.util.List;

/**
 * 服务端
 */
public class MyServerService extends Service {
    private static final String TAG = "tag-" + MyServerService.class.getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "===========onCreate=============");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "===========onRebind=============");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {

        return new IMyAidlInterface.Stub() {

            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }

            @Override
            public void addStudent(Student student) throws RemoteException {
                DataUtils.getStudentList().add(student);
            }

            @Override
            public List<Student> getStudentList() throws RemoteException {
                return DataUtils.getStudentList();
            }
        };
    }
}