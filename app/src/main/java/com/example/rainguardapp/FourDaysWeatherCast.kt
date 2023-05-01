package com.example.rainguardapp

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class FourDaysWeatherCast : AppCompatActivity() {
    lateinit var CITY: String
    val API: String = "d78a400532d5206b8ee146c6946a2706"

    @Serializable
    data class Forecast(
        @SerialName("city")
        val city: City,
        @SerialName("cod")
        val cod: String,
        @SerialName("message")
        val message: Int,
        @SerialName("cnt")
        val cnt: Int,
        @SerialName("list")
        val list: List<ForecastListItem>
    )

    @Serializable
    data class City(
        @SerialName("id")
        val id: Int,
        @SerialName("name")
        val name: String,
        @SerialName("coord")
        val coord: Coord,
        @SerialName("country")
        val country: String,
        @SerialName("timezone")
        val timezone: Int,
        @SerialName("sunrise")
        val sunrise: Long,
        @SerialName("sunset")
        val sunset: Long
    )

    @Serializable
    data class Coord(
        @SerialName("lat")
        val lat: Double,
        @SerialName("lon")
        val lon: Double
    )

    @Serializable
    data class ForecastListItem(
        @SerialName("dt")
        val dt: Long,
        @SerialName("sunrise")
        val sunrise: Long,
        @SerialName("sunset")
        val sunset: Long,
        @SerialName("temp")
        val temp: Temp,
        @SerialName("feels_like")
        val feelsLike: FeelsLike,
        @SerialName("pressure")
        val pressure: Int,
        @SerialName("humidity")
        val humidity: Int,
        @SerialName("weather")
        val weather: List<Weather>,
        @SerialName("speed")
        val speed: Double,
        @SerialName("deg")
        val deg: Int,
        @SerialName("gust")
        val gust: Double,
        @SerialName("clouds")
        val clouds: Int,
        @SerialName("pop")
        val pop: Double,
        @SerialName("uvi")
        val uvi: Double
    )

    @Serializable
    data class Temp(
        @SerialName("day")
        val day: Double,
        @SerialName("min")
        val min: Double,
        @SerialName("max")
        val max: Double,
        @SerialName("night")
        val night: Double,
        @SerialName("eve")
        val eve: Double,
        @SerialName("morn")
        val morn: Double
    )

    @Serializable
    data class FeelsLike(
        @SerialName("day")
        val day: Double,
        @SerialName("night")
        val night: Double,
        @SerialName("eve")
        val eve: Double,
        @SerialName("morn")
        val morn: Double
    )

    @Serializable
    data class Weather(
        @SerialName("id")
        val id: Int,
        @SerialName("main")
        val main: String,
        @SerialName("description")
        val description: String,
        @SerialName("icon")
        val icon: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four_days)
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
            Log.i("cityName", CITY)
            try {
                response =
                    URL("https://api.openweathermap.org/data/2.5/forecast/daily?q=$CITY&cnt=5&units=metric&appid=$API").readText(
                        Charsets.UTF_8
                    )
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

                val jsonObj = JSONObject(result)
                val weatherList = jsonObj.getJSONArray("list")
                for (i in 0 until weatherList.length()) {
                    val weatherObj = weatherList.getJSONObject(i)
                    val date = weatherObj.getLong("dt")
                    val dateNormal = Date(date * 1000)
                    val dateFormat = SimpleDateFormat("EEEE, MMMM d", Locale.getDefault())
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
                }


                findViewById<TextView>(R.id.avgTemp1).text = averageTemperatures[0]
                findViewById<TextView>(R.id.date1).text = datesString[0]
                findViewById<TextView>(R.id.status1).text = descriptions[0]
                findViewById<TextView>(R.id.temp_min_max1).text = "Min Temp: " + minTemperatures[0] + "°C" + "/Max Temp: " + maxTemperatures[0] +"°C"


                findViewById<TextView>(R.id.avgTemp2).text = averageTemperatures[1]
                findViewById<TextView>(R.id.date2).text = datesString[1]
                findViewById<TextView>(R.id.status2).text = descriptions[1]
                findViewById<TextView>(R.id.temp_min_max2).text = "Min Temp: " + minTemperatures[1] + "°C" + "/Max Temp: " + maxTemperatures[1] +"°C"

                findViewById<TextView>(R.id.avgTemp3).text = averageTemperatures[2]
                findViewById<TextView>(R.id.date3).text = datesString[2]
                findViewById<TextView>(R.id.status3).text = descriptions[2]
                findViewById<TextView>(R.id.temp_min_max3).text = "Min Temp: " + minTemperatures[2] + "°C" + "/Max Temp: " + maxTemperatures[2] +"°C"

                findViewById<TextView>(R.id.avgTemp4).text = averageTemperatures[3]
                findViewById<TextView>(R.id.date4).text = datesString[3]
                findViewById<TextView>(R.id.status4).text = descriptions[3]
                findViewById<TextView>(R.id.temp_min_max4).text = "Min Temp: " + minTemperatures[3] + "°C" + "/Max Temp: " + maxTemperatures[3] +"°C"

                findViewById<TextView>(R.id.avgTemp5).text = averageTemperatures[4]
                findViewById<TextView>(R.id.date5).text = datesString[4]
                findViewById<TextView>(R.id.status5).text = descriptions[4]
                findViewById<TextView>(R.id.temp_min_max5).text = "Min Temp: " + minTemperatures[4] + "°C" + "/Max Temp: " + maxTemperatures[4] +"°C"


                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<LinearLayout>(R.id.mainContainer).visibility = View.VISIBLE
            } catch (e: Exception) {
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
            }
        }
    }
}