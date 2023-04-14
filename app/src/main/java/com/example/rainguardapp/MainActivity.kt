package com.example.rainguardapp

import android.location.Geocoder
import android.os.AsyncTask
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.gms.location.LocationServices
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var latIntent = intent.getDoubleExtra("lat", 1.5)
        var lonIntent = intent.getDoubleExtra("lon", 1.5)
        Log.i("Test", latIntent.toString())
        Log.i("Test", lonIntent.toString())

        val url = "https://api.openweathermap.org/data/2.5/weather?lat=" +
                latIntent + "&lon=" + lonIntent + "&appid=" + key + "&units=metric&lang=ua"



    }

    private class GetURLData: AsyncTask<String, String, String>() {
        override fun doInBackground(vararg p0: String?): String {
            TODO("Not yet implemented")
        }

    }

    companion object {
        const val key = "d78a400532d5206b8ee146c6946a2706"
    }

}