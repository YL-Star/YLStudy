package com.yl.study

import android.os.Bundle
import android.os.Process
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yl.study.annotation.InjectUtils
import com.yl.study.annotation.IntentParam
import com.yl.study.annotation.Person
import com.yl.study.sync_msg.Utils
import java.util.concurrent.*

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

        Log.d("tag-", "name:" + Utils.getMap("name"))
        val thread = Thread(futureTask, "test sync msg")
        thread.start()
        try {
            Log.d("tag-", "result:" + futureTask.get())
        } catch (e: ExecutionException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        Log.d("tag-", "msg:" + sendSyncMessageWithTask(futureTask))
        val result = Utils.sendMessageSyncTask()
        Log.d("tag-", "sendMsg call back:$result")
        val callable: Callable<*> = Callable<Any?> {
            Thread.sleep(4000)
            Log.d("tag-", "===tread:" + Thread.currentThread().toString())
            "=== =="
        }
        val executor = Executors.newCachedThreadPool()
        val future: Future<String> = executor.submit(callable) as Future<String>
        try {
            Log.d("tag-", "result:" + future.get())
        } catch (e: ExecutionException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    var futureTask = FutureTask {
        Thread.sleep(3000)
        Log.d("tag-", "tread:" + Thread.currentThread().toString())
        "==result=="
    }


    private fun sendSyncMessageWithTask(task: FutureTask<String>): String? {
        try {
            return task.get()
        } catch (e: ExecutionException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return null
    }
}