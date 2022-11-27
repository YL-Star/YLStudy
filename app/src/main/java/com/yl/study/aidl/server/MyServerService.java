package com.yl.study.aidl.server;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.yl.study.IMyAidlInterface;
import com.yl.study.MyApplication;
import com.yl.study.TwoActivity;
import com.yl.study.aidl.bean.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务端
 */
public class MyServerService extends Service {
    private static final String TAG = "tag-" + MyServerService.class.getSimpleName();

    private MyServerService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "===========onCreate=============");
        startActivity(new Intent(this, TwoActivity.class));
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
//         TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
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