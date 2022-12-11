package com.yl.study.command

import android.content.Intent
import com.google.auto.service.AutoService
import com.yl.base.BaseApplication
import com.yl.webview.Command
import com.yl.webview.WebViewActivity

/**
 * @date: $ $
 * @author: yanglei
 * @description
 *
 */
@AutoService(Command::class)
class CommandStartWebViewActivity:Command {
    override fun name(): String {
        return "startWebViewActivity"
    }

    override fun execute(jsonParam: String) {
        val intent = Intent(BaseApplication.context, WebViewActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        BaseApplication.context.startActivity(intent)
    }
}