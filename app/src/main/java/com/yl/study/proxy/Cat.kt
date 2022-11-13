package com.yl.study.proxy

import android.util.Log

/**
 * @date: $ $
 * @author: yanglei
 * @description
 *
 */
class Cat :Animal {
    override fun eat() {
        Log.d("tag-", "=========cat eat=========")
    }

    override fun doing() {
        Log.d("tag-", "=========cat doing=========")
    }
}