package com.example.ui_module.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gear_module.domain.GearRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.map

class GearViewModel(gearRepository: GearRepository) : ViewModel() {
    val gearState = gearRepository.observeGearChanges()
        .map { gear -> mapGearToText(gear) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "N/A")

    private fun mapGearToText(gear: Int): String = when (gear) {
        0 -> "Park (P)"
        1 -> "Reverse (R)"
        2 -> "Neutral (N)"
        3 -> "Drive (D)"
        else -> "Unknown"
    }
}
