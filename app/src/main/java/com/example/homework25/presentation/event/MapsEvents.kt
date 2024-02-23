package com.example.homework25.presentation.event

sealed class MapsEvents {
    data object GetUserLocation : MapsEvents()
    data class GetPlaceLocation(val placeName: String) : MapsEvents()
}