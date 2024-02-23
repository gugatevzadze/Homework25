package com.example.homework25.di

import android.content.Context
import com.example.homework25.data.repository.PlaceLocationRepositoryImpl
import com.example.homework25.data.repository.UserLocationRepositoryImpl
import com.example.homework25.domain.repository.PlaceLocationRepository
import com.example.homework25.domain.repository.UserLocationRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.libraries.places.api.net.PlacesClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePlaceLocationRepository(
        context: Context,
        placesClient: PlacesClient
    ): PlaceLocationRepository {
        return PlaceLocationRepositoryImpl(
            context = context,
            placesClient = placesClient
        )
    }

    @Provides
    @Singleton
    fun provideUserLocationRepository(
        context: Context,
        locationProvider: FusedLocationProviderClient
    ): UserLocationRepository {
        return UserLocationRepositoryImpl(
            context = context,
            locationProvider = locationProvider
        )
    }
}