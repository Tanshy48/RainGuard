package com.example.rainguardapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class Setting : AppCompatActivity() {
    lateinit var CITY:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting)
        CITY= intent.getStringExtra("Address").toString()
    }
    var chose = "0"
    var lange = "0"
    fun LanguageENG(view: View) {
        val lang = "en"
        lange = "0"
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        recreate()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Address", CITY)
        intent.putExtra("key", chose)
        intent.putExtra("lang", lange)
        startActivity(intent)
    }
    fun LanguageUKR(view: View) {
        val lang = "ukr"
        lange = "1"
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        recreate()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Address", CITY)
        intent.putExtra("key", chose)
        intent.putExtra("lang", lange)
        startActivity(intent)
    }
    fun F(view: View){
        chose="1"
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("key", chose)
        intent.putExtra("Address", CITY)
        intent.putExtra("lang", lange)
        startActivity(intent)
    }
    fun C(view: View){
        chose="0"
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("key", chose)
        intent.putExtra("Address", CITY)
        intent.putExtra("lang", lange)
        startActivity(intent)
    }


}