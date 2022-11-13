package com.yl.study.proxy

import android.util.Log

/**
 * @date: $ $
 * @author: yanglei
 * @description
 *
 */
class Dog : Animal {
    override fun eat() {
        Log.d("tag-", "=========dog, eat=========")
    }

    override fun color() {
         Log.d("tag-", "=========dog - color : yellow =========")
    }
}