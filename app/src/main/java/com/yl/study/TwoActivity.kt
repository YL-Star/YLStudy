package com.yl.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yl.study.annotation.InjectUtils
import com.yl.study.annotation.IntentParam
import com.yl.study.annotation.Person

class TwoActivity : AppCompatActivity() {
    // 自定义key
    @IntentParam(key = "name_")
    var name: String? = null

    //默认key
    @IntentParam
    var age: Int? = null

    @IntentParam
    var person: Person?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        InjectUtils.parseIntentParams(this)
        Log.d("tag-", "name:$name;age:$age;persion:${person.toString()}")//name:jack;age:10
    }
}