package com.sunnyweather.android.logic.model

import com.zk.sunnyweather.logic.model.RealtimeResponse

data class Weather(val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily)