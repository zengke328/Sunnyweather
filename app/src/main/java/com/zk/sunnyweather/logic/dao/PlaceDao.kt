package com.zk.sunnyweather.logic.dao

import com.google.gson.Gson
import com.zk.common.MmkvUtils
import com.zk.sunnyweather.logic.model.Place

/**
 * description ：
 * author : zk
 * date : 2020/10/22 19:47
 */

object PlaceDao {

    fun savePlace(place: Place) {
        MmkvUtils.putString("place",Gson().toJson(place))
    }

    fun getSavedPlace(): Place {
        val placeJson = MmkvUtils.getString("place","")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = MmkvUtils.contains("place")

}