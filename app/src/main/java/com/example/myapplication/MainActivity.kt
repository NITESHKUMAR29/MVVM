package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var mainViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
            val dao=QuoteDataBase.getDataBase(applicationContext).quoteDao()

       val repositary=MyRepositary(dao)
        mainViewModel=
            ViewModelProvider(this,MyViewModelFactory(repositary)).get(MyViewModel::class.java)

        binding.button.setOnClickListener {
        mainViewModel.getQuote().observe(this,{
            binding.textView.text=it.toString()
        })
        }
    }
}