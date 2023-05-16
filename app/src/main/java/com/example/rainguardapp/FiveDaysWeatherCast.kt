package com.example.rainguardapp

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class FiveDaysWeatherCast : AppCompatActivity() {
    lateinit var CITY: String
    lateinit var value: String
    lateinit var lange: String
    lateinit var chose: String
    val API: String = "d78a400532d5206b8ee146c6946a2706"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five_days)
        CITY = intent.getStringExtra("Address").toString()
        weatherTask().execute()
    }

    inner class weatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
            findViewById<LinearLayout>(R.id.mainContainer).visibility = View.GONE
            findViewById<TextView>(R.id.errorText).visibility = View.GONE
        }

        override fun doInBackground(vararg params: String?): String? {
            var response: String?
            value = intent.getStringExtra("more").toString()
            lange = intent.getStringExtra("lange").toString()
            if(value=="0" && lange == "0") chose = "1"
            else if(value=="0" && lange == "1") chose = "2"
            else if(value=="1" && lange == "1") chose = "3"
            else if(value=="1" && lange == "0") chose = "4"
            else chose = "1"
            try {
                when (chose){
                    "1"-> response =
                        URL("https://api.openweathermap.org/data/2.5/forecast/daily?q=$CITY&cnt=5&units=metric&appid=$API").readText(
                            Charsets.UTF_8
                        )
                    "2"->response =
                        URL("https://api.openweathermap.org/data/2.5/forecast/daily?q=$CITY&cnt=5&units=metric&appid=$API&lang=uk").readText(
                            Charsets.UTF_8
                        )
                    "3"->response =
                        URL("https://api.openweathermap.org/data/2.5/forecast/daily?q=$CITY&cnt=5&appid=$API&lang=uk").readText(
                            Charsets.UTF_8
                        )
                    "4"-> response =
                        URL("https://api.openweathermap.org/data/2.5/forecast/daily?q=$CITY&cnt=5&appid=$API").readText(
                            Charsets.UTF_8
                        )
                    else -> response =
                        URL("https://api.openweathermap.org/data/2.5/forecast/daily?q=$CITY&cnt=5&units=metric&appid=$API").readText(
                            Charsets.UTF_8
                        )
                }
            } catch (e: Exception) {
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            try {
                val datesString = Array(5) { "" }
                val averageTemperatures = Array(5) { "" }
                val minTemperatures = Array(5) { "" }
                val maxTemperatures = Array(5) { "" }
                val descriptions = Array(5) { "" }
                val imgsrc = Array(5){""}

                val jsonObj = JSONObject(result)
                val weatherList = jsonObj.getJSONArray("list")
                for (i in 0 until weatherList.length()) {
                    val weatherObj = weatherList.getJSONObject(i)
                    val date = weatherObj.getLong("dt")
                    val dateNormal = Date(date * 1000)
                    lange = intent.getStringExtra("lange").toString()
                    var dateFormat: SimpleDateFormat? = null
                    when (lange){
                        "0" -> dateFormat = SimpleDateFormat("EEEE, MMMM d", Locale.ENGLISH)
                        "1" -> dateFormat = SimpleDateFormat("EEEE, MMMM d", Locale.UK)
                        else -> dateFormat = SimpleDateFormat("EEEE, MMMM d", Locale.ENGLISH)
                    }
                    val formattedDate = dateFormat.format(dateNormal)
                    datesString[i] = formattedDate.toString()
                    val tempObj = weatherObj.getJSONObject("temp")
                    val averageTemperature = tempObj.getDouble("day")
                    averageTemperatures[i] = averageTemperature.toString()
                    val minTemperature = tempObj.getDouble("min")
                    minTemperatures[i] = minTemperature.toString()
                    val maxTemperature = tempObj.getDouble("max")
                    maxTemperatures[i] = maxTemperature.toString()
                    val weatherArray = weatherObj.getJSONArray("weather")
                    val weather = weatherArray.getJSONObject(0)
                    val description = weather.getString("description")
                    descriptions[i] = description.toString()
                    imgsrc[i] = "https://openweathermap.org/img/wn/${weather.getString("icon")}.png"
                }


                findViewById<TextView>(R.id.avgTemp1).text = averageTemperatures[0]
                findViewById<TextView>(R.id.date1).text = datesString[0]
                findViewById<TextView>(R.id.status1).text = descriptions[0]
                value = intent.getStringExtra("more").toString()
                lange = intent.getStringExtra("lange").toString()
                if(value=="0" && lange == "0") chose = "1"
                else if(value=="0" && lange == "1") chose = "2"
                else if(value=="1" && lange == "1") chose = "3"
                else if(value=="1" && lange == "0") chose = "4"
                else chose = "1"
                when(chose){
                    "1" -> findViewById<TextView>(R.id.temp_min_max1).text = "Min Temp: " + minTemperatures[0] + "°C" + "/Max Temp: " + maxTemperatures[0] +"°C"
                    "2" -> findViewById<TextView>(R.id.temp_min_max1).text = "Мін. темп. " + minTemperatures[0] + "°C" + "/Макс. темп. " + maxTemperatures[0] +"°C"
                    "3" -> findViewById<TextView>(R.id.temp_min_max1).text = "Мін. темп. " + minTemperatures[0] + "°F" + "/Макс. темп. " + maxTemperatures[0] +"°F"
                    "4" -> findViewById<TextView>(R.id.temp_min_max1).text = "Min Temp: " + minTemperatures[0] + "°F" + "/Max Temp: " + maxTemperatures[0] +"°F"
                    else -> findViewById<TextView>(R.id.temp_min_max1).text = "Min Temp: " + minTemperatures[0] + "°C" + "/Max Temp: " + maxTemperatures[0] +"°C"
                }
                val imageView1 = findViewById<ImageView>(R.id.icon1)
                Glide.with(this@FiveDaysWeatherCast)
                    .load(imgsrc[0])
                    .into(imageView1)

                findViewById<TextView>(R.id.avgTemp2).text = averageTemperatures[1]
                findViewById<TextView>(R.id.date2).text = datesString[1]
                findViewById<TextView>(R.id.status2).text = descriptions[1]
                when(chose){
                    "1" -> findViewById<TextView>(R.id.temp_min_max2).text = "Min Temp: " + minTemperatures[0] + "°C" + "/Max Temp: " + maxTemperatures[0] +"°C"
                    "2" -> findViewById<TextView>(R.id.temp_min_max2).text = "Мін. темп. " + minTemperatures[0] + "°C" + "/Макс. темп. " + maxTemperatures[0] +"°C"
                    "3" -> findViewById<TextView>(R.id.temp_min_max2).text = "Мін. темп. " + minTemperatures[0] + "°F" + "/Макс. темп. " + maxTemperatures[0] +"°F"
                    "4" -> findViewById<TextView>(R.id.temp_min_max2).text = "Min Temp: " + minTemperatures[0] + "°F" + "/Max Temp: " + maxTemperatures[0] +"°F"
                    else -> findViewById<TextView>(R.id.temp_min_max2).text = "Min Temp: " + minTemperatures[0] + "°C" + "/Max Temp: " + maxTemperatures[0] +"°C"
                }
                val imageView2 = findViewById<ImageView>(R.id.icon2)
                Glide.with(this@FiveDaysWeatherCast)
                    .load(imgsrc[1])
                    .into(imageView2)

                findViewById<TextView>(R.id.avgTemp3).text = averageTemperatures[2]
                findViewById<TextView>(R.id.date3).text = datesString[2]
                findViewById<TextView>(R.id.status3).text = descriptions[2]
                when(chose){
                    "1" -> findViewById<TextView>(R.id.temp_min_max3).text = "Min Temp: " + minTemperatures[0] + "°C" + "/Max Temp: " + maxTemperatures[0] +"°C"
                    "2" -> findViewById<TextView>(R.id.temp_min_max3).text = "Мін. темп. " + minTemperatures[0] + "°C" + "/Макс. темп. " + maxTemperatures[0] +"°C"
                    "3" -> findViewById<TextView>(R.id.temp_min_max3).text = "Мін. темп. " + minTemperatures[0] + "°F" + "/Макс. темп. " + maxTemperatures[0] +"°F"
                    "4" -> findViewById<TextView>(R.id.temp_min_max3).text = "Min Temp: " + minTemperatures[0] + "°F" + "/Max Temp: " + maxTemperatures[0] +"°F"
                    else -> findViewById<TextView>(R.id.temp_min_max3).text = "Min Temp: " + minTemperatures[0] + "°C" + "/Max Temp: " + maxTemperatures[0] +"°C"
                }
                val imageView3 = findViewById<ImageView>(R.id.icon3)
                Glide.with(this@FiveDaysWeatherCast)
                    .load(imgsrc[2])
                    .into(imageView3)


                findViewById<TextView>(R.id.avgTemp4).text = averageTemperatures[3]
                findViewById<TextView>(R.id.date4).text = datesString[3]
                findViewById<TextView>(R.id.status4).text = descriptions[3]
                when(chose){
                    "1" -> findViewById<TextView>(R.id.temp_min_max4).text = "Min Temp: " + minTemperatures[0] + "°C" + "/Max Temp: " + maxTemperatures[0] +"°C"
                    "2" -> findViewById<TextView>(R.id.temp_min_max4).text = "Мін. темп. " + minTemperatures[0] + "°C" + "/Макс. темп. " + maxTemperatures[0] +"°C"
                    "3" -> findViewById<TextView>(R.id.temp_min_max4).text = "Мін. темп. " + minTemperatures[0] + "°F" + "/Макс. темп. " + maxTemperatures[0] +"°F"
                    "4" -> findViewById<TextView>(R.id.temp_min_max4).text = "Min Temp: " + minTemperatures[0] + "°F" + "/Max Temp: " + maxTemperatures[0] +"°F"
                    else -> findViewById<TextView>(R.id.temp_min_max4).text = "Min Temp: " + minTemperatures[0] + "°C" + "/Max Temp: " + maxTemperatures[0] +"°C"
                }
                val imageView4 = findViewById<ImageView>(R.id.icon4)
                Glide.with(this@FiveDaysWeatherCast)
                    .load(imgsrc[3])
                    .into(imageView4)

                findViewById<TextView>(R.id.avgTemp5).text = averageTemperatures[4]
                findViewById<TextView>(R.id.date5).text = datesString[4]
                findViewById<TextView>(R.id.status5).text = descriptions[4]
                when(chose){
                    "1" -> findViewById<TextView>(R.id.temp_min_max5).text = "Min Temp: " + minTemperatures[0] + "°C" + "/Max Temp: " + maxTemperatures[0] +"°C"
                    "2" -> findViewById<TextView>(R.id.temp_min_max5).text = "Мін. темп. " + minTemperatures[0] + "°C" + "/Макс. темп. " + maxTemperatures[0] +"°C"
                    "3" -> findViewById<TextView>(R.id.temp_min_max5).text = "Мін. темп. " + minTemperatures[0] + "°F" + "/Макс. темп. " + maxTemperatures[0] +"°F"
                    "4" -> findViewById<TextView>(R.id.temp_min_max5).text = "Min Temp: " + minTemperatures[0] + "°F" + "/Max Temp: " + maxTemperatures[0] +"°F"
                    else -> findViewById<TextView>(R.id.temp_min_max5).text = "Min Temp: " + minTemperatures[0] + "°C" + "/Max Temp: " + maxTemperatures[0] +"°C"
                }
                val imageView5 = findViewById<ImageView>(R.id.icon5)
                Glide.with(this@FiveDaysWeatherCast)
                    .load(imgsrc[4])
                    .into(imageView5)

                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<LinearLayout>(R.id.mainContainer).visibility = View.VISIBLE
            } catch (e: Exception) {
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
            }
        }
    }
}