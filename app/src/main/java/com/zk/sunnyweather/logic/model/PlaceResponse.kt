package com.zk.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * description ：将数据模型加上data关键字的声明。
 * author : zk
 * date : 2020/10/22 19:51
 */

data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(val name: String, val location: Location, @SerializedName("formatted_address") val address: String)

data class Location(val lng: String, val lat: String)