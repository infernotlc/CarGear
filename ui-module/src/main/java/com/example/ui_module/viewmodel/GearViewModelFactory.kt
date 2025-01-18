package com.example.ui_module.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gear_module.domain.GearRepository

class GearViewModelFactory(private val gearRepository: GearRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GearViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GearViewModel(gearRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
