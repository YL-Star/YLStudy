package com.yl.study.proxy

import android.util.Log

/**
 * @date: $ $
 * @author: yanglei
 * @description
 *
 */
interface Animal {
    fun color() {
        Log.d("tag-", "=========color=========")
    }

    fun eat() {
        Log.d("tag-", "=========eat=========")
    }

    fun doing() {
        Log.d("tag-", "=========doing=========")
    }
}