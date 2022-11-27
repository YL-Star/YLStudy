package com.yl.study.memory

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yl.study.R

class MemoryActivity : AppCompatActivity() {
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory)

    }
    fun getMemory() {
        val activityManager: ActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        // 系统分配的内存
        val memoryClass = activityManager.memoryClass
        val largeMemoryClass = activityManager.largeMemoryClass

        Log.d("tag-","memoryClass:$memoryClass;largeMemoryClass：$largeMemoryClass")

        // 系统最大分配内存
        val maxMemory = Runtime.getRuntime().maxMemory()
        // 未使用的内存
        val freeMemory = Runtime.getRuntime().freeMemory()
        //已经使用的内存
        val totalMemory = Runtime.getRuntime().totalMemory()
    }

    /**
     * https://blog.csdn.net/lxy1740/article/details/114023007
     * https://www.cnblogs.com/ganchuanpu/p/7455793.html
     *
     */
    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        when(level){
            TRIM_MEMORY_UI_HIDDEN ->{

            }
            TRIM_MEMORY_COMPLETE  ->{

            }
            TRIM_MEMORY_RUNNING_LOW ->{

            }

        }

    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
}