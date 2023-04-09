package com.example.rainguardapp

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class LocationsCity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setContentView(com.example.rainguardapp.R.layout.locations_city)
        val spinner = findViewById<Spinner>(com.example.rainguardapp.R.id.spinner1)
        val value = intent.getStringExtra("key")
        when (value) {
            "Автономна Республіка Крим" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesCrimea, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Вінницька" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesVinnytsia, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Волинська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesVolyn, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Дніпропетровська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesDnipro, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Донецька" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesDonetsk, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Житомирська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesZhytomyr, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Закарпатська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesZakarpattia, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Запорізька" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesZaporizhzhia, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Івано-Франківська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesIvanoFrankivsk, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Київська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKyiv, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Кіровоградська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKirovohrad, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Луганська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesLuhansk, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Львівська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesLviv, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Миколаївська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesMykolaiv, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Одеська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesOdessa, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Полтавська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesPoltava, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Рівненська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesRivne, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Сумська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesSumy, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Тернопільська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesTernopil, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Харківська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKharkiv, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Херсонська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKherson, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Хмельницька" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKhmelnytsk, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Черкаська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesCherkasy, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Чернівецька" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesChernivtsi, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Чернігівська" -> {
                val adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesChernihiv, R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
        }
    }
        fun Back(view: View) {
            val intent = Intent(this@LocationsCity, LocationsOB::class.java)
            startActivity(intent)
        }


    }