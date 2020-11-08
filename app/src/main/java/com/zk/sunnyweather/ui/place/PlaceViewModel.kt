package com.zk.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.zk.sunnyweather.logic.Repository
import com.zk.sunnyweather.logic.model.Place

class PlaceViewModel : ViewModel() {

    val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }


    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

}