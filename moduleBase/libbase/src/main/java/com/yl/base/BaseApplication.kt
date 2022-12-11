package com.yl.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.tencent.mmkv.MMKV

/**
 * @date: $ $
 * @author: yanglei
 * @description
 *
 */
 open class BaseApplication : Application() {
  companion object{
       @SuppressLint("StaticFieldLeak")
     public  lateinit var context: Context
  }

    override fun onCreate() {
        super.onCreate()
        context = this
        val rootDir: String = MMKV.initialize(this)
        println("tag- mmkv root: $rootDir")
    }

}