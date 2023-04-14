package com.example.rainguardapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class LocationsOB:AppCompatActivity() {

    lateinit var item: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setContentView(R.layout.locations_ob)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(
            this, R.array.regions, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item)
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

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }

        spinner.onItemSelectedListener = itemSelectedListener

    }

    fun Select(view: View) {
        val intent = Intent(this, LocationsCity::class.java)
        intent.putExtra("key",item)
        startActivity(intent)
    }
}