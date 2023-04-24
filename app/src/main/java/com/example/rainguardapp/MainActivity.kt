package com.example.rainguardapp

import android.content.Intent
import android.location.Geocoder
import android.os.AsyncTask
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.gms.location.LocationServices
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var optionButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        optionButton = findViewById(R.id.button5)
        optionButton.setOnClickListener{
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
        }
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
    fun toSetting(view: View) {
        val intent = Intent(this, Setting::class.java)
        startActivity(intent)
    }
    fun toAdd(view: View) {
        val intent = Intent(this, AdditionalPage::class.java)
        startActivity(intent)
    }

}