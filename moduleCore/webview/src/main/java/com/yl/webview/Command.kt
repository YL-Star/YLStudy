package com.yl.webview

/**
 * @date: $ $
 * @author: yanglei
 * @description
 *
 */
interface Command {
    fun name():String

    fun execute(jsonParam:String)
}