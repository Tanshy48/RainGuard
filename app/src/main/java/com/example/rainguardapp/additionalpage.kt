package com.example.rainguardapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class additionalpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.additionalpage)
    }
fun chooseCity(view: View){

    val chooseIntent = Intent(this,LocationsCity::class.java)
    startActivity(chooseIntent)
}
    fun reportProblem(view: View){
        val reportIntent = Intent (this, reportProblem::class.java)
        startActivity(reportIntent)
     }

 }