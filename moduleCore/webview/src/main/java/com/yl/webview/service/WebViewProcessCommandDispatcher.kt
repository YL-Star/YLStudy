package com.yl.webview.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import com.yl.base.BaseApplication
import com.yl.webview.IWebViewProcessToMainProcess

/**
 * WebView进程的指令分发。
 *
 * @date: $ $
 * @author: yanglei
 * @description
 */
internal object WebViewProcessCommandDispatcher : ServiceConnection {

    private var asInterface: IWebViewProcessToMainProcess? = null

    fun initAidlConnection() {
        val intent = Intent(BaseApplication.context, MainProcessCommandService::class.java)
        BaseApplication.context.bindService(intent, this, Context.BIND_AUTO_CREATE)
    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        asInterface = IWebViewProcessToMainProcess.Stub.asInterface(service)
        Log.d("tag-","WebView AidlConnection 连接成功")
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        asInterface = null
        Log.e("tag-","WebView AidlConnection 连接断开")
    }

    fun executeCommand(commandName: String, jsonParam: String) {
        asInterface?.handleWebCommand(commandName, jsonParam)
    }

}