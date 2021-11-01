package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(private val repositary: MyRepositary):ViewModel() {
    fun getQuote():LiveData<List<Quote>>{
       return repositary.getQuote()
    }
    fun insertQuote(quote: Quote){
        viewModelScope.launch(Dispatchers.IO) {
            repositary.insertQuote(quote)
        }

    }

}