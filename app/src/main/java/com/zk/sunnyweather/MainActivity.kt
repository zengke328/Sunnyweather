package com.zk.sunnyweather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (SunnyWeatherApplication.TOKEN.isEmpty()) {
            toast("hahah ")
            finish()
        }

    }
}
