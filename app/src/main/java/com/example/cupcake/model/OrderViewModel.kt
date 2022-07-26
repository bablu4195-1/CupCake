package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel: ViewModel() {
    private val _quantity = MutableLiveData<Int>(0)
    val quantity: LiveData<Int> = _quantity

    private val _flavor = MutableLiveData<String>("")
    val flavor: LiveData<String> = _flavor

    private val _date = MutableLiveData<String>("")
    val date: LiveData<String> = _date

    private val _price = MutableLiveData<Double>(0.0)
    val price: LiveData<Double> = _price


    fun setQuantity(numberCupCakes: Int){
        _quantity.value = numberCupCakes
    }

    fun setFlavor(flavor: String){
        _flavor.value = flavor
    }

    fun setDate(date: String){
        _date.value = date
    }
}