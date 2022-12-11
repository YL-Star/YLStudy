package com.yl.webview.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.ArrayMap
import android.util.Log
import com.yl.webview.Command
import com.yl.webview.IWebViewProcessToMainProcess
import java.util.ServiceLoader

class MainProcessCommandService : Service() {
    private val arrayMap = ArrayMap<String, Command>()
    override fun onCreate() {
        super.onCreate()
        Log.d("tag-", "===========onCreate=============")
        val load = ServiceLoader.load(Command::class.java)
        for (command in load) {
            val name = command.name()
            Log.d("tag-", "command name:$name")
            arrayMap[name] = command
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        return object : IWebViewProcessToMainProcess.Stub() {
            override fun handleWebCommand(commandName: String?, jsonParam: String?) {
                jsonParam?.let { arrayMap[commandName]?.execute(it) }
            }
        }
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        arrayMap.clear()
    }

}