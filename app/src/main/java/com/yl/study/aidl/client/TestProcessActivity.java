package com.yl.study.aidl.client;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.yl.study.IMyAidlInterface;
import com.yl.study.R;
import com.yl.study.TwoActivity;
import com.yl.study.aidl.bean.Student;
import com.yl.study.aidl.server.DataUtils;

import java.util.Arrays;
import java.util.List;

public class TestProcessActivity extends AppCompatActivity {
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Debug.stopMethodTracing();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
//        getLifecycle().addObserver(presenter);

        Log.d(
                "tag-",
                "====TestActivity==onCreate============" + Process.myPid() + ";" + Process.myUid()
        );
//        presenter.bindService();
        findViewById(R.id.btn).setOnClickListener(v -> {

//            presenter.addStudent(new Student("Tom", 19));
//            List<Student> studentList = presenter.getStudentList();
//            Log.d("tag-", "student:" + Arrays.toString(studentList.toArray()));

        });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("hahaThread-name");
        thread.start();

    }

    private final Presenter presenter = new Presenter(this, new ICallback() {
        @Override
        public void onSuccess(IMyAidlInterface iMyAidlInterface) {

        }

        @Override
        public void onFailed() {

        }
    });

}