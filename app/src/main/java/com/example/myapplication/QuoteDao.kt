package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {
    @Insert
   suspend fun insert(quote: Quote)

 @Query("SELECT * from quote")
 fun getData():LiveData<List<Quote>>


}