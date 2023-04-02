package com.example.rainguardapp

<<<<<<< HEAD
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class additionalpage : AppCompatActivity() {
=======
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class additionalpage: AppCompatActivity() {
>>>>>>> origin/Banias
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.additionalpage)
    }
<<<<<<< HEAD
fun chooseCity(view: View){

    val chooseIntent = Intent(this,LocationsCity::class.java)
    startActivity(chooseIntent)
}
    fun reportProblem(view: View){
        val reportIntent = Intent (this, reportProblem::class.java)
        startActivity(reportIntent)
     }

 }
=======

}
>>>>>>> origin/Banias
