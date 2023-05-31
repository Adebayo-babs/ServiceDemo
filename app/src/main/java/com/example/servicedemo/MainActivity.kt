package com.example.servicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.servicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val serviceIntent = Intent(this, MyBackgroundService::class.java)
        serviceIntent.putExtra(MyBackgroundService.NAME, "ALEX")
        serviceIntent.putExtra(MyBackgroundService.MARKS, 70)
        binding.apply {
            btnStart.setOnClickListener{
                Log.i(MyBackgroundService.TAG, "Starting service")
                startService(serviceIntent)
            }
            btnStop.setOnClickListener{
                Log.i(MyBackgroundService.TAG, "Stopping service")
                stopService(serviceIntent)
            }
        }
    }
}