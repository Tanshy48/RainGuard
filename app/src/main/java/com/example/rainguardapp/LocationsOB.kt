package com.example.rainguardapp

import android.R
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class LocationsOB:AppCompatActivity() {

    lateinit var item: String
    var ob = arrayOf("Автономна Республіка Крим", "Вінницька", "Волинська", "Дніпропетровська", "Донецька", "Житомирська", "Закарпатська", "Запорізька", "Івано-Франківська", "Київська", "Кіровоградська", "Луганська", "Львівська", "Миколаївська", "Одеська", "Полтавська", "Рівненська", "Сумська", "Тернопільська", "Харківська", "Херсонська", "Хмельницька", "Черкаська", "Чернівецька", "Чернігівська")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setContentView(com.example.rainguardapp.R.layout.locations_ob)
        val spinner = findViewById<Spinner>(com.example.rainguardapp.R.id.spinner)
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, R.layout.simple_spinner_item, ob)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(adapter)
        val itemSelectedListener: AdapterView.OnItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {

                     item = parent.getItemAtPosition(position) as String
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

        spinner.onItemSelectedListener = itemSelectedListener

    }

    fun Select(view: View) {
        val intent = Intent(this, LocationsCity::class.java)
        intent.putExtra("key",item)
        startActivity(intent)
    }
}