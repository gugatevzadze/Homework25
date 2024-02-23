package com.example.homework25.domain.repository

import android.location.Location

interface UserLocationRepository {
    suspend fun getUserLocation(): Location?
}