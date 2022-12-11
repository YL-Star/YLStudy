package com.yl.study.command

import android.content.Intent
import android.util.Log
import com.google.auto.service.AutoService
import com.yl.base.BaseApplication
import com.yl.userlogin.ui.login.LoginActivity
import com.yl.webview.Command

/**
 * @date: $ $
 * @author: yanglei
 * @description
 *
 */
@AutoService(Command::class)
class CommandLogin : Command {

    override fun name(): String {
        return "login"
    }

    override fun execute(jsonParam: String) {
        Log.d("tag-", "login --- jsonParam:$jsonParam")
        val intent = Intent(BaseApplication.context, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        BaseApplication.context.startActivity(intent)
    }
}