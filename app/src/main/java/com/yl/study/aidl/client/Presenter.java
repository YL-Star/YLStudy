package com.yl.study.aidl.client;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import com.yl.study.IMyAidlInterface;
import com.yl.study.aidl.bean.Student;

import java.util.Arrays;
import java.util.List;

/**
 * 客户端调用binder
 *
 * @date: $ $
 * @author: yanglei
 * @description
 */
public class Presenter implements DefaultLifecycleObserver {
    private static final String TAG = "tag-"+Presenter.class.getSimpleName();
    Activity activity;
    ICallback callback;

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onCreate(owner);
        Log.d(TAG,"==========onCreate===========");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onDestroy(owner);
        Log.d(TAG,"==========onDestroy===========");
        activity.unbindService(conn);
        activity = null;
    }

    public Presenter(Activity activity, ICallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    public void bindService() {
        ComponentName componentName = new ComponentName("com.yl.study", "com.yl.study.aidl.server.MyServerService");
        Intent intent = new Intent();
        intent.setComponent(componentName);
//        activity.startService(intent);
        activity.bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    private IMyAidlInterface iMyAidlInterface;
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            callback.onSuccess(iMyAidlInterface);
            Toast.makeText(activity, "连接binder成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            callback.onFailed();
            Toast.makeText(activity, "binder连接断开", Toast.LENGTH_SHORT).show();
        }
    };

    public void addStudent(Student student) {
        try {
            iMyAidlInterface.addStudent(student);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudentList() {
        try {
            List<Student> studentList = iMyAidlInterface.getStudentList();
//            Log.d("tag-", "studentList" + Arrays.toString(studentList.toArray()));
            return studentList;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }


}
