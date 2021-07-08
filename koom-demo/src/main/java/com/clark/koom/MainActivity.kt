package com.clark.koom

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clark.leaklib.CrashHandler
import com.clark.leaklib.LeakMaker

class MainActivity : AppCompatActivity(), CrashHandler.CrashCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) === PackageManager.PERMISSION_GRANTED)) {
                val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                requestPermissions(permissions, 101)
            }
        }

        CrashHandler.getInstance().setCrashCallback(this)

        findViewById<View>(R.id.btn_test).setOnClickListener {
            LeakMaker.makeLeak(this@MainActivity)
        }
    }

    override fun uncaughtException(t: Thread, e: Throwable) {
        
    }
}