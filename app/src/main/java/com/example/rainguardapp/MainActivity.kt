package com.example.rainguardapp

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import com.bumptech.glide.Glide
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var CITY: String
    lateinit var value:String
    val API: String = "d78a400532d5206b8ee146c6946a2706"
    lateinit var showMoreButton: Button
    lateinit var optionButton: Button
    lateinit var additionalPageButton: Button
    lateinit var windSpeed:String
    lateinit var temp:String
    lateinit var tempMax:String
    lateinit var tempMin:String
    var updatedAt by Delegates.notNull<Long>()
    var sunrise by Delegates.notNull<Long>()
    var sunset by Delegates.notNull<Long>()
    lateinit var updatedAtText: String
    lateinit var sunriseText: String
    lateinit var sunsetText: String

    lateinit var lange: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CITY = intent.getStringExtra("Address").toString()
        weatherTask().execute()

        optionButton = findViewById(R.id.settings)
        additionalPageButton = findViewById(R.id.additionalPage)
        showMoreButton = findViewById(R.id.showMore)

        additionalPageButton.setOnClickListener {
            val intent = Intent(this, AdditionalPage::class.java)
            startActivity(intent)
        }

        optionButton.setOnClickListener{
            val intent = Intent(this, Setting::class.java)
            intent.putExtra("Address", CITY)
            startActivity(intent)
        }
        showMoreButton.setOnClickListener {
            val intent = Intent(this, FiveDaysWeatherCast::class.java)
            intent.putExtra("Address", CITY)
            startActivity(intent)
        }
    }
    fun toSetting(view: View){
        val intent = Intent(this@MainActivity, Setting::class.java)
        startActivity(intent)
    }
    fun toAdd(view: View){
        val intent = Intent(this@MainActivity, AdditionalPage::class.java)
        startActivity(intent)
    }
    fun More (view: View){
        val intent = Intent(this, FiveDaysWeatherCast::class.java)
        intent.putExtra("Address", CITY)
        intent.putExtra("more", value)
        intent.putExtra("lang", lange)
        startActivity(intent)
    }
    inner class weatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
            findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.GONE
            findViewById<TextView>(R.id.errorText).visibility = View.GONE
        }
        override fun doInBackground(vararg params: String?): String? {
            var response:String?
            try{
                value = intent.getStringExtra("key").toString()
                lange = intent.getStringExtra("lang").toString()
                intent.putExtra("more", value)
                intent.putExtra("lang", lange)
                when (value){
                    "0" -> response = URL("https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API").readText(
                        Charsets.UTF_8
                    )
                    "1" -> response = URL("https://api.openweathermap.org/data/2.5/weather?q=$CITY&appid=$API").readText(
                        Charsets.UTF_8
                    )
                    else -> response = URL("https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API").readText(
                        Charsets.UTF_8
                    )
                }

            }catch (e: Exception){
                response = null
            }
            return response
        }
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            try {
                value = intent.getStringExtra("key").toString()
                lange = intent.getStringExtra("lang").toString()
                /* Extracting JSON returns from the API */
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val wind = jsonObj.getJSONObject("wind")
                updatedAt = jsonObj.getLong("dt")
                sunrise = sys.getLong("sunrise")
                sunset = sys.getLong("sunset")
                when (value){
                    "0" -> {
                        updatedAtText = SimpleDateFormat("dd/MM/yyyy HH:mm a", Locale.ENGLISH).format(Date(updatedAt*1000))
                        sunsetText = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset*1000))
                        sunriseText = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise*1000))
                        windSpeed = " " + wind.getString("speed")+" м/s"
                        temp = " " + main.getString("temp") + "°C"
                        tempMin = " " + main.getString("temp_min") + "°C"
                        tempMax = " " + main.getString("temp_max") + "°C"
                    }
                    "1" -> {
                        updatedAtText = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(Date(updatedAt*1000))
                        sunsetText = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset*1000))
                        sunriseText = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise*1000))
                        windSpeed = " " + wind.getString("speed")+"ft/s"
                        temp = " " + main.getString("temp") + "°F"
                        tempMin =  " " + main.getString("temp_min") + "°F"
                        tempMax =  " " + main.getString("temp_max") + "°F"
                    }
                    else -> {
                        updatedAtText = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(Date(updatedAt*1000))
                        sunsetText = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset*1000))
                        sunriseText = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise*1000))
                        windSpeed = " " + wind.getString("speed") + "м/s"
                        temp = " " + main.getString("temp") + "°C"
                        tempMin = " " + main.getString("temp_min") + "°C"
                        tempMax = " " + main.getString("temp_max") + "°C"
                    }
                }
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)
                val updatedAt:Long = jsonObj.getLong("dt")
                val updatedAtText = "Updated at: "+ SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(Date(updatedAt*1000))
                val pressure = main.getString("pressure")
                val humidity = main.getString("humidity")
                val sunrise:Long = sys.getLong("sunrise")
                val sunset:Long = sys.getLong("sunset")
                val weatherDescription = weather.getString("description")
                val address = jsonObj.getString("name")+", "+sys.getString("country")
                val imgsrc = "https://openweathermap.org/img/wn/${weather.getString("icon")}.png"
                /* Populating extracted data into our views */
                findViewById<TextView>(R.id.address).text = address
                findViewById<TextView>(R.id.updated_at).text =  updatedAtText
                findViewById<TextView>(R.id.temp).text = temp
                findViewById<TextView>(R.id.temp_min1).text = tempMin
                findViewById<TextView>(R.id.temp_max1).text = tempMax
                findViewById<TextView>(R.id.sunrise).text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise*1000))
                findViewById<TextView>(R.id.sunset).text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset*1000))
                findViewById<TextView>(R.id.wind).text = windSpeed
                findViewById<TextView>(R.id.pressure).text = pressure
                findViewById<TextView>(R.id.humidity).text = humidity
                val imageView = findViewById<ImageView>(R.id.icon)
                Glide.with(this@MainActivity)
                    .load(imgsrc)
                    .into(imageView)

                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE
            } catch (e: Exception) {
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
            }
        }
    }
}


