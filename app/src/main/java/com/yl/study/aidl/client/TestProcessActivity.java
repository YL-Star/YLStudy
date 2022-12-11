package com.yl.study.aidl.client;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.yl.study.IMyAidlInterface;
import com.yl.study.R;

public class TestProcessActivity extends AppCompatActivity {
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        Debug.stopMethodTracing();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Log.d(
                "tag-",
                "====TestActivity==onCreate============" + Process.myPid() + ";" + Process.myTid()
        );
        initView();
        initData();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {
            ComponentName componentName = new ComponentName(this, "com.yl.study.TwoActivity");
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setComponent(componentName);
            startActivity(intent);
//            startActivity(new Intent(this, MainActivityProcessor.getClass("/app/MainActivity")));
        });
    }

    private void initData() {
        presenter.bindService();
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