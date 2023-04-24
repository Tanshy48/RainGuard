package com.example.rainguardapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.widget.TextView
import com.google.android.gms.location.*
import java.util.concurrent.TimeUnit
import android.location.Geocoder
import java.util.Locale


class LoginActivity : AppCompatActivity() {
    lateinit var progressBar: ProgressBar
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var locationRequest: LocationRequest
    val REQUEST_CODE = 101


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = ProgressBar.VISIBLE


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        getLocation()
}

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        if(checkPermissions()) {
            if(isLocationEnabled()){

                fusedLocationProviderClient.lastLocation.addOnCompleteListener { task ->
                    val location = task.result
                    if (location == null)
                        getNewLocation()


                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("lat", location.latitude)
                    intent.putExtra("lon", location.longitude)
                    startActivity(intent)

                }

            } else {
                Toast.makeText(this, "Turn on location", Toast.LENGTH_SHORT).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }

        } else {
            requestPermission()
        }
    }

    @SuppressLint("MissingPermission")
    private fun getNewLocation() {
        locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 1
        locationRequest.fastestInterval = 1
        locationRequest.numUpdates = 1

        fusedLocationProviderClient!!.requestLocationUpdates(
            locationRequest, locationCallback, Looper.myLooper()
        )
    }



    private val locationCallback = object : LocationCallback(){
        override fun onLocationResult(p0: LocationResult) {
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_CODE)
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private fun checkPermissions(): Boolean {
        if(ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            return true
        }
        return false
}



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation()
            } else {
                TimeUnit.SECONDS.sleep(2L)
                progressBar.visibility = ProgressBar.INVISIBLE
                val intent = Intent(this, LocationsOB::class.java)
                startActivity(intent)
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}