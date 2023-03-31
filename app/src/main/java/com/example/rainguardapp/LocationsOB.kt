package com.example.rainguardapp

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class LocationsOB:AppCompatActivity(){
        var ob = arrayOf("Автономна Республіка Крим", "Вінницька", "Волинська", "Дніпропетровська", "Донецька", "Житомирська", "Закарпатська", "Запорізька", "Івано-Франківська", "Київська", "Кіровоградська", "Луганська", "Львівська", "Миколаївська", "Одеська", "Полтавська", "Рівненська", "Сумська", "Тернопільська", "Харківська", "Херсонська", "Хмельницька", "Черкаська", "Чернівецька", "Чернігівська")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(com.example.rainguardapp.R.layout.locations_ob)
            val spinner = findViewById<Spinner>(com.example.rainguardapp.R.id.spinner)
            val adapter: ArrayAdapter<Any?> =
                ArrayAdapter<Any?>(this, R.layout.simple_spinner_item, ob)
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        fun Select (view:View){
            val intent = Intent(this@LocationsOB, LocationsCity::class.java)
            intent.putExtra("ob", ob)
            startActivity(intent)
        }

    }