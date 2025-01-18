package com.example.gear_module.domain

import android.car.hardware.CarPropertyValue
import android.car.hardware.property.CarPropertyManager
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow


class GearRepository(private val carPropertyManager: CarPropertyManager) {

    fun observeGearChanges(): Flow<Int> = callbackFlow {
        val callback = object : CarPropertyManager.CarPropertyEventCallback {
            override fun onChangeEvent(event: CarPropertyValue<*>) {
                if (event.propertyId == GEAR_SELECTION_ID) {
                    val gear = event.value as Int
                    trySend(gear).isSuccess
                }
            }

            override fun onErrorEvent(propertyId: Int, zone: Int) {
                close(IllegalStateException("Error for property $propertyId"))
            }
        }

        carPropertyManager.registerCallback(callback, GEAR_SELECTION_ID, CarPropertyManager.SENSOR_RATE_NORMAL)
        awaitClose { carPropertyManager.unregisterCallback(callback) }
    }

    companion object {
        const val GEAR_SELECTION_ID = 289408000
    }
}
