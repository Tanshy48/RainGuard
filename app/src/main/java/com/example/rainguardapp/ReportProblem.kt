package com.example.rainguardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ReportProblem : AppCompatActivity() {
    lateinit var reportProblemButton: Button
    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_problem)
        reportProblemButton = findViewById(R.id.readyButtonReportProblem)
        editText = findViewById(R.id.editTextTextMultiLine)
        reportProblemButton.setOnClickListener {
            editText.setText("")
            Toast.makeText(this, R.string.readyReportButton, Toast.LENGTH_SHORT).show()
        }
    }
}