package com.yl.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yl.study.annotation.Person
import com.yl.study.proxy.TestJava

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TestJava().test()

        startActivity(Intent(this,TwoActivity::class.java)
            .putExtra("name_","jack")
            .putExtra("age",10)
            .putExtra("person", Person("tom", 11)))

    }
}