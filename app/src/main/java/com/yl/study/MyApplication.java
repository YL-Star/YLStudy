package com.yl.study;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;

import java.io.File;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
public class MyApplication extends Application {
    public MyApplication() {
        // 统计耗时。文件名；文件保存大小；捕捉频率，
//        Debug.startMethodTracingSampling(new File(Environment.getExternalStorageDirectory(),
//                "study_tracing_log").getAbsolutePath(), 8 * 1024 * 1024, 1_000);
    }
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
//        context = getApplicationContext();
//        context = getBaseContext();
    }

    public static Context getContext() {
        return context;
    }
}
