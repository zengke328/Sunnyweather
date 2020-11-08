package com.zk.sunnyweather.logic

import androidx.lifecycle.liveData
import com.sunnyweather.android.logic.model.Weather
import com.zk.sunnyweather.logic.model.Place
import com.zk.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import org.jetbrains.anko.custom.async

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


    fun refreshWeather(lng: String,lat :String) = liveData(Dispatchers.IO) {

        val result = try {
            coroutineScope {
                val getDaily =async {
                    SunnyWeatherNetwork.getDailyWeather(lng,lat)
                }

                val 

            }



        }catch (e: Exception){
            Result.failure<List<Weather>>(e)
        }
        emit(result)
    }

}