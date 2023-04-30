package com.example.rainguardapp

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class LocationsCity:AppCompatActivity() {
    lateinit var adapter: ArrayAdapter<CharSequence>
    lateinit var city: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setContentView(com.example.rainguardapp.R.layout.locations_city)
        val spinner = findViewById<Spinner>(com.example.rainguardapp.R.id.spinner1)
        val value = intent.getStringExtra("key")
        when (value) {
            "Автономна Республіка Крим" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesCrimea, R.layout.simple_spinner_item)
            }
            "Autonomous Republic of Crimea" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesCrimea, R.layout.simple_spinner_item)
            }
            "Вінницька" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesVinnytsia, R.layout.simple_spinner_item)
            }
            "Vinnytsia" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesVinnytsia, R.layout.simple_spinner_item)
            }
            "Волинська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesVolyn, R.layout.simple_spinner_item)
            }
            "Volyn" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesVolyn, R.layout.simple_spinner_item)
            }
            "Дніпропетровська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesDnipro, R.layout.simple_spinner_item)
            }
            "Dnipropetrovsk" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesDnipro, R.layout.simple_spinner_item)
            }
            "Донецька" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesDonetsk, R.layout.simple_spinner_item)
            }
            "Donetsk" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesDonetsk, R.layout.simple_spinner_item)
            }
            "Житомирська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesZhytomyr, R.layout.simple_spinner_item)
            }
            "Zhytomyr" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesZhytomyr, R.layout.simple_spinner_item)
            }
            "Закарпатська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesZakarpattia, R.layout.simple_spinner_item)
                }
            "Zakarpattia" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesZakarpattia, R.layout.simple_spinner_item)
            }
            "Запорізька" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesZaporizhzhia, R.layout.simple_spinner_item)
            }
            "Zaporizhzhia" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesZaporizhzhia, R.layout.simple_spinner_item)
            }
            "Івано-Франківська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesIvanoFrankivsk, R.layout.simple_spinner_item)
            }
            "Ivano-Frankivsk" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesIvanoFrankivsk, R.layout.simple_spinner_item)
            }
            "Київська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKyiv, R.layout.simple_spinner_item)
                }
            "Kyiv" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKyiv, R.layout.simple_spinner_item)
            }
            "Кіровоградська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKirovohrad, R.layout.simple_spinner_item)
                }
            "Kirovohrad" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKirovohrad, R.layout.simple_spinner_item)
            }
            "Луганська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesLuhansk, R.layout.simple_spinner_item)
                }
            "Luhansk" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesLuhansk, R.layout.simple_spinner_item)
            }
            "Львівська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesLviv, R.layout.simple_spinner_item)
                }
            "Lviv" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesLviv, R.layout.simple_spinner_item)
            }
            "Миколаївська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesMykolaiv, R.layout.simple_spinner_item)
                }
            "Mykolaiv" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesMykolaiv, R.layout.simple_spinner_item)
            }
            "Одеська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesOdessa, R.layout.simple_spinner_item)
                }
            "Odesa" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesOdessa, R.layout.simple_spinner_item)
            }
            "Полтавська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesPoltava, R.layout.simple_spinner_item)
                }
            "Poltava" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesPoltava, R.layout.simple_spinner_item)
            }
            "Рівненська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesRivne, R.layout.simple_spinner_item)
                }
            "Rivne" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesRivne, R.layout.simple_spinner_item)
            }
            "Сумська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesSumy, R.layout.simple_spinner_item)
                }
            "Sumy" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesSumy, R.layout.simple_spinner_item)
            }
            "Тернопільська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesTernopil, R.layout.simple_spinner_item)
                }
            "Ternopil" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesTernopil, R.layout.simple_spinner_item)
            }
            "Харківська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKharkiv, R.layout.simple_spinner_item)
                }
            "Kharkiv" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKharkiv, R.layout.simple_spinner_item)
            }
            "Херсонська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKherson, R.layout.simple_spinner_item)
                }
            "Kherson" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKherson, R.layout.simple_spinner_item)
            }
            "Хмельницька" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKhmelnytsk, R.layout.simple_spinner_item)
                }
            "Khmelnytskyi" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesKhmelnytsk, R.layout.simple_spinner_item)
            }
            "Черкаська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesCherkasy, R.layout.simple_spinner_item)
                }
            "Cherkasy" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesCherkasy, R.layout.simple_spinner_item)
            }
            "Чернівецька" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesChernivtsi, R.layout.simple_spinner_item)
                }
            "Chernivtsi" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesChernivtsi, R.layout.simple_spinner_item)
            }
            "Чернігівська" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesChernihiv, R.layout.simple_spinner_item)
                }
            "Chernihiv" -> {
                adapter = ArrayAdapter.createFromResource(
                    this, com.example.rainguardapp.R.array.citiesChernihiv, R.layout.simple_spinner_item)
            }
        }
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

                    city = parent.getItemAtPosition(position) as String
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }

        spinner.onItemSelectedListener = itemSelectedListener
    }
        fun Back(view: View) {
            val intent = Intent(this, LocationsOB::class.java)
            startActivity(intent)
        }
    fun Start(view: View){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Address", city)
        startActivity(intent)
    }
}