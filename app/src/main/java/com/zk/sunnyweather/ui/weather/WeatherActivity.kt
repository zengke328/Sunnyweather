package com.zk.sunnyweather.ui.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.zk.sunnyweather.R

/**
 * description ：
 * author : zk
 * date : 2020/11/12 15:29
 */

class WeatherActivity : AppCompatActivity() {

    val viewModel = lazy { ViewModelProviders.of(this).get(WeatherViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
    }

}