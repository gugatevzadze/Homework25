package com.example.homework25.domain.repository

import android.location.Location

interface PlaceLocationRepository {
    suspend fun getPlacesLocation(placeName: String): Location?
}