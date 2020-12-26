package com.example.maththat.MVVM

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maththat.RomanNumber
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    val data = MutableLiveData<String>()
    val data2 = MutableLiveData<Int>()
    val calcData = MutableLiveData<String>()
    val calcData1 = MutableLiveData<Double>()
    val calcData2 = MutableLiveData<Double>()
    val calcSign = MutableLiveData<Int>()

    init {
        calcSign.postValue(0)
        calcData1.postValue(0.0)
        calcData2.postValue(0.0)
    }

    fun setData(text: Int){
        viewModelScope.launch(Dispatchers.IO) {
            if (text == 0) data.postValue("")
            else data.postValue(RomanNumber.ConvertNumber(text))
        }
    }

    fun setData2(text: String){
        viewModelScope.launch(Dispatchers.IO) {
            if (text.isEmpty()) data2.postValue(0)
            else data2.postValue(RomanNumber.ConvertRoman(text))
        }
    }

    fun setcalcData(text: String){
        viewModelScope.launch(Dispatchers.IO) {
            if (text.isNotEmpty()) calcData.postValue(text)
            else calcData.postValue("0")
        }
    }

    fun setcalcData1(number: Double){
        viewModelScope.launch(Dispatchers.IO) {
            calcData1.postValue(number)
        }
    }

    fun setcalcData2(number: Double){
        viewModelScope.launch(Dispatchers.IO) {
            calcData2.postValue(number)
        }
    }

    fun setcalcSign(sign: Int){
        viewModelScope.launch(Dispatchers.IO) {
            calcSign.postValue(sign)
        }
    }
}