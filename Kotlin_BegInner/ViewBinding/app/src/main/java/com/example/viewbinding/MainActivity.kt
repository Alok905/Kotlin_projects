package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.inflate
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewbinding.R.layout.recyclerview_item
import com.example.viewbinding.databinding.ActivityMainBinding
import com.example.viewbinding.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {
    private var binding :ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.recyclerView?.adapter = MainAdapter(TaskList.taskList)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}