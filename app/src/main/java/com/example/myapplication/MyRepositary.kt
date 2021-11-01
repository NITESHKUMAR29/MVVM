package com.example.myapplication

import androidx.lifecycle.LiveData

class MyRepositary(private val quoteDao: QuoteDao) {
     fun getQuote():LiveData<List<Quote>>{
        return quoteDao.getData()
     }
 suspend fun insertQuote(quote: Quote){
     quoteDao.insert(quote)
 }

}