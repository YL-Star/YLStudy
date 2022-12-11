package com.yl.webview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yl.annotation.arouter.ARouter

@ARouter(path = "/WebView/TencentWebViewActivity")
class TencentWebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tencent_web_view)
    }
}