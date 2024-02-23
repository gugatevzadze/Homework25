package com.example.homework25.presentation.state

import android.location.Location

data class MapsState(
    val errorMessage: String? = null,
    val userLocation: Location? = null,
    val placeLocation: Location? = null
)