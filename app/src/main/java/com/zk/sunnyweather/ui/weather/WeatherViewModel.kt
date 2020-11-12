package com.zk.sunnyweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.zk.sunnyweather.logic.Repository
import com.zk.sunnyweather.logic.model.Location

/**
 * description ：
 * author : zk
 * date : 2020/11/12 15:31
 */

class WeatherViewModel : ViewModel() {

    val locationLiveData = MutableLiveData<Location>()
    var locationLng = ""

    var locationLat = ""

    var placeName = ""

    val weatherLiveData = Transformations.switchMap(locationLiveData) { location ->
        Repository.refreshWeather(location.lng, location.lat, placeName)
    }

    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = Location(lng, lat)
    }
}