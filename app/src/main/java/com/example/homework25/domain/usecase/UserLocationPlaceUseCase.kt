package com.example.homework25.domain.usecase

import com.example.homework25.domain.repository.UserLocationRepository
import javax.inject.Inject

class UserLocationPlaceUseCase @Inject constructor(
    private val userLocationRepository: UserLocationRepository
) {
    suspend operator fun invoke() = userLocationRepository.getUserLocation()
}