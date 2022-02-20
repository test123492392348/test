package com.kg.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kg.sampleproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        val data = ArrayList<String>()
        for(i in 0 until 10)
            data.add("Hello World")

        val adapter = Adapter(data)
        binding.recyclerView.adapter =adapter

    }
}