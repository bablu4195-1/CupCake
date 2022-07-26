package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

private const val PRICE_PER_CUPCAKE = 3.00 //:) Due to inflation, this is the price of a cupcake.

class OrderViewModel: ViewModel() {

    val dateOptions = getPickUpOptions()

    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity

    private val _flavor = MutableLiveData<String>()
    val flavor: LiveData<String> = _flavor

    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    private val _price = MutableLiveData<Double>()
    val price: LiveData<Double> = _price


    fun setQuantity(numberCupCakes: Int){
        _quantity.value = numberCupCakes
        updatePrice()
    }

    fun setFlavor(flavor: String){
        _flavor.value = flavor
    }

    fun setDate(date: String){
        _date.value = date
    }

    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }

    private fun getPickUpOptions(): List<String> {
        val options = mutableListOf<String>()

        val formatter =  SimpleDateFormat("E MMM d", Locale.getDefault())

        val calendar = Calendar.getInstance()

        repeat(4){
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }
    init{
        resetOrder()
    }
    fun resetOrder() {
        _quantity.value = 0
        _flavor.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0
    }

    private fun updatePrice() {
        _price.value = (quantity.value ?: 0) * PRICE_PER_CUPCAKE
    }


}