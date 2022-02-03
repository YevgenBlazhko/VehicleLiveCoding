package com.example.swivllivecoding.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val vehicles: MutableLiveData<List<Vehicle>> = MutableLiveData()

    private val listVehicles = listOf(
        Vehicle("Audi", 2008, 10000),
        Vehicle("BMW", 2020, 50000),
        Vehicle("Mazda", 2015, 23000),
        Vehicle("Honda", 2018, 40000),
        Vehicle("Ford", 2012, 15000),
        Vehicle("Renault", 2009, 13000),
        Vehicle("Mercedes", 2019, 33000),
        Vehicle("Skoda", 2005, 7000),
        Vehicle("Toyota", 2014, 17000),
        Vehicle("Jaguar", 2022, 77000)
    )

    fun setList() {
        vehicles.value = listVehicles
    }

}

data class Vehicle(
    val name: String,
    val yearIssue: Int,
    val price: Int
)