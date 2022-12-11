package com.yl.study

import android.content.Context
import android.util.Log
import com.yl.base.BaseApplication

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
//@HiltAndroidApp
public class MyApplication : BaseApplication() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Log.d("tag-","==========MyApplication attachBaseContext==============="+System.currentTimeMillis())
    }
    override fun onCreate() {
        super.onCreate()
        Log.d("tag-","==========MyApplication onCreate()============="+System.currentTimeMillis())

    }
}