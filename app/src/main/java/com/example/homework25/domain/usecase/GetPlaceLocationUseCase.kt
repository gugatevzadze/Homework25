package com.example.homework25.domain.usecase

import com.example.homework25.domain.repository.PlaceLocationRepository
import javax.inject.Inject

class GetPlaceLocationUseCase @Inject constructor(
    private val placeLocationRepository: PlaceLocationRepository
) {
    suspend operator fun invoke(placeName: String) = placeLocationRepository.getPlacesLocation(placeName = placeName)
}