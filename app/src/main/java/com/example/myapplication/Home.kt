package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()

        val startButton : Button = findViewById(R.id.startButton)

        startButton.setOnClickListener {
            val intent = Intent(this, RecyclerView::class.java)
            startActivity(intent)
        }
    }
}