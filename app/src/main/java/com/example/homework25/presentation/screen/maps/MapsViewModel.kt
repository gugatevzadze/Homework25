package com.example.homework25.presentation.screen.maps

import android.location.Location
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework25.domain.usecase.GetPlaceLocationUseCase
import com.example.homework25.domain.usecase.UserLocationPlaceUseCase
import com.example.homework25.presentation.event.MapsEvents
import com.example.homework25.presentation.state.MapsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val userLocationPlaceUseCase: UserLocationPlaceUseCase,
    private val getPlaceLocationUseCase: GetPlaceLocationUseCase
): ViewModel() {

    private val _userLocation = MutableStateFlow(MapsState())
    val userLocation: SharedFlow<MapsState> get() = _userLocation

    private val _placeLocation = MutableStateFlow(MapsState())
    val placeLocation: SharedFlow<MapsState> get() = _placeLocation

    fun onEvent(event: MapsEvents) {
        when (event) {
            is MapsEvents.GetUserLocation -> getUserLocation()
            is MapsEvents.GetPlaceLocation -> getPlaceLocation(event.placeName)
        }
    }

    private fun getUserLocation() {
        viewModelScope.launch {
            val location = userLocationPlaceUseCase()
            _userLocation.value = MapsState(userLocation = location)
        }
    }

    private fun getPlaceLocation(placeName: String) {
        Log.d("MapsViewModel", "Getting location for place: $placeName")
        viewModelScope.launch {
            val placeLocation = getPlaceLocationUseCase(placeName)
            _placeLocation.value = MapsState(placeLocation = placeLocation)
            Log.d("MapsViewModel", "Getting location for place: $placeLocation")
        }
    }
}