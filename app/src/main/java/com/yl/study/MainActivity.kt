package com.yl.study

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Process
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yl.annotation.arouter.ARouter
import com.yl.base.ServiceLoadUtils
import com.yl.comm.autoservice.IWebViewService
import com.yl.study.aidl.bean.Student
import com.yl.study.aidl.client.TestProcessActivity
import com.yl.study.aidl.server.DataUtils
import com.yl.study.annotation.Person
import com.yl.study.camera.CameraActivity
import com.yl.study.databinding.ActivityMainBinding
import com.yl.study.utils.CheckPermissionUtils
import java.util.*
@ARouter(path = "/app/MainActivity")
class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = "tag-" + MainActivity::class.java.simpleName
    }

    private lateinit var binding: ActivityMainBinding

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        // 停止监控
        // Debug.stopMethodTracing()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        DataBindingUtil.insetContentView(this,R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(
            "tag-",
            "====MainActivity==onCreate============" + Process.myPid() + ";" + Process.myTid()
        )
        initView()
        initData()
        registerReceiver()

    }

    private fun initData() {
        DataUtils.getStudentList().add(Student("jack", 12))
        DataUtils.getStudentList().add(Student("jack", 13))
        DataUtils.getStudentList().add(Student("jack", 14))
    }

    private fun initView() {
        binding.jumpProcessBtn.setOnClickListener {
            startActivity(
                Intent(this, TestProcessActivity::class.java)
                    .putExtra("name_", "jack")
                    .putExtra("age", 10)
                    .putExtra("person", Person("tom", 11))
            )
        }

        binding.cameraxBtn.setOnClickListener {
            CheckPermissionUtils.setContext(this, CheckPermissionUtils.InterfPermission {
                startActivity(Intent(this, CameraActivity::class.java))
            }).CheckCamera()
        }

        binding.hiltTest.setOnClickListener {
//            startActivity(Intent(this, HiltTestActivity::class.java))
        }

        binding.webView.setOnClickListener {
            val load = ServiceLoadUtils.load(IWebViewService::class.java)
            load.startWebViewActivity(this, "https://m.baidu.com")
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        CheckPermissionUtils.setContext(this)
            .onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun registerReceiver() {

        val intent = IntentFilter()
        intent.addAction("com.yl.study.myBroadcast")
        registerReceiver(broadcastReceiver, intent)
        // LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intent)
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "=========onDestroy=========")
        DataUtils.getStudentList().clear();
        unregisterReceiver(broadcastReceiver)
        //  LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver)
    }

    private var broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (TextUtils.equals(intent.action, "com.yl.study.myBroadcast")) {
                Log.d(TAG, "=====onReceive=======")

            }
        }
    }


}