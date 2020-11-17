package com.zk.sunnyweather.logic

import android.util.Log
import androidx.lifecycle.liveData
import com.sunnyweather.android.logic.model.Weather
import com.zk.sunnyweather.logic.model.Place
import com.zk.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {

        val result = try {

            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                Result.success(placeResponse.places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }


    fun refreshWeather(lng: String, lat: String, placeName: String) = liveData(Dispatchers.IO) {

        val result = try {
            coroutineScope {
                val deferredDaily =async {
                    SunnyWeatherNetwork.getDailyWeather(lng,lat)
                }
                val deferredRealtime = async {
                    SunnyWeatherNetwork.getRealtimeWeather(lng, lat)
                }
                val dailyResponse =  deferredDaily.await()
                val realtimeResponse =  deferredRealtime.await()

                if (realtimeResponse.status == "ok" && dailyResponse.status == "ok") {
                    Log.d("http refreshWeather realtimeResponse ",realtimeResponse.result.toString())
                    val weather =
                        Weather(realtimeResponse.result.realtime, dailyResponse.result.daily)
                    Result.success(weather)
                } else {
                    Result.failure(RuntimeException("realtime response status is ${realtimeResponse.status}" +
                            "daily response status is ${dailyResponse.status}"))
                }
            }
        }catch (e: Exception){
            Result.failure<List<Weather>>(e)
        }
        emit(result)
    }


}