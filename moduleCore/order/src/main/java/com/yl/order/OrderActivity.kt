package com.yl.order

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yl.annotation.arouter.ARouter

@ARouter(path = "/order/OrderActivity")
class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
    }
}