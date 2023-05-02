package com.example.rainguardapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import javax.mail.*

class ReportProblem : AppCompatActivity() {
    lateinit var reportProblemButton: Button
    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_problem)
        reportProblemButton = findViewById(R.id.readyButtonReportProblem)
        editText = findViewById(R.id.editTextTextMultiLine)
        reportProblemButton.setOnClickListener {
            val recipient = "vasheimya@spamok.com"
            val subject = "Report"
            val message = editText.text.toString()

            //method call for email intent with these inputs as parameters
            sendEmail(recipient, subject, message)
            editText.setText("")
            Toast.makeText(this, R.string.readyReportButton, Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT, message)

        try {
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        }
        catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }
}