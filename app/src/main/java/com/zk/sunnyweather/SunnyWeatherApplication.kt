package com.zk.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * description ：
 * author : zk
 * date : 2020/10/20 15:53
 */

class SunnyWeatherApplication : Application() {


    companion object {
        const val TOKEN = "lV1LpulcYRHHnLIH" // 填入你申请到的令牌值

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}