package com.example.gearapp


import android.car.hardware.property.CarPropertyManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gear_module.domain.GearRepository
import com.example.ui_module.screen.GearScreen
import com.example.ui_module.viewmodel.GearViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val carPropertyManager = getSystemService(CarPropertyManager::class.java)
        val repository = GearRepository(carPropertyManager)
        val viewModel = GearViewModel(repository)

        setContent {
            GearScreen(viewModel)
        }
    }
}
