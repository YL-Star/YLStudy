package com.yl.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yl.annotation.arouter.ARouter
import com.yl.webview.databinding.ActivityWebViewBinding
import com.yl.webview.service.WebViewProcessCommandDispatcher
@ARouter(path = "/WebView/WebViewActivity")
class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tag-", "======WebViewActivity=========")
//        setContentView(R.layout.activity_web_view)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initView() {

        val webView = binding.webView
        webView.settings.javaScriptEnabled = true
        intent.getStringExtra("url")?.let { webView.loadUrl(it) }

        binding.loginBtn.setOnClickListener {
            Log.d("tag-", "WebViewProcessCommandDispatcher send command:start")
            // 跨进程通信：发送数据到Main进程
            WebViewProcessCommandDispatcher.executeCommand("login", "{'name':'jack'}")

        }
    }
    private fun initData(){
        WebViewProcessCommandDispatcher.initAidlConnection()
    }


}