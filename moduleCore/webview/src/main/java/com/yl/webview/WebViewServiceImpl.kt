package com.yl.webview

import android.content.Context
import android.content.Intent
import com.google.auto.service.AutoService
import com.yl.comm.autoservice.IWebViewService

/**
 * @date: $ $
 * @author: yanglei
 * @description
 *
 */
@AutoService(IWebViewService::class)
public class WebViewServiceImpl : IWebViewService {
    override fun startWebViewActivity(context: Context, url: String) {
        val intent = Intent(context, WebViewActivity::class.java)
        intent.putExtra("url", url)
        context.startActivity(intent)
    }
}