package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*
import kotlin.concurrent.schedule

class StartApp : AppCompatActivity() {
    val studentName = arrayOf("Rohan Shah", "Harsh Joshi", "Fahad Kabir")
    val studentNumbers = arrayOf("8847495","8831554","8824642")


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_app)
        val txtRohan : TextView = findViewById(R.id.txtStudent1)
        val txtHarsh : TextView = findViewById(R.id.txtStudent2)
        val txtFahad : TextView = findViewById(R.id.txtStudent3)
        val btnStart: Button = findViewById(R.id.btnStartApp)

        txtRohan.text = studentName[0] + "\n " + "(" + studentNumbers[0] + ")"
        txtHarsh.text = studentName[1] + "\n " + "(" + studentNumbers[1] + ")"
        txtFahad.text = studentName[2] + "\n " + "(" + studentNumbers[2] + ")"
        btnStart.setOnClickListener {
            val intent = Intent(it.context.applicationContext, UserAuthActivity::class.java)
            startActivity(intent)

        }
    }

}