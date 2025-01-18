package com.example.gear_module.domain

import android.car.Car
import android.car.hardware.property.CarPropertyManager
import android.content.Context


class CarRepository(context:Context) {
    val car = Car.createCar(context)
    val carPropertyManager = car.getCarManager(Car.PROPERTY_SERVICE) as CarPropertyManager

}