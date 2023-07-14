package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import org.w3c.dom.Text

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val i = intent

        val gname = i.getStringExtra("Name")
        val gprice = i.getStringExtra("Price")
        val gquant = i.getStringExtra("Quantity")
        val imgUri = i.getStringExtra("ImageUrl")
        val genre = i.getStringExtra("Genre")

        val txtName :TextView = findViewById(R.id.txtGameTitle)
        val txtGenre : TextView = findViewById(R.id.txtGenre)
        val txtQuantity : TextView = findViewById(R.id.txtQuantity)
        val btnPrice : Button = findViewById(R.id.btnPrice)
        val imgCover : ImageView = findViewById(R.id.imgCover)

        txtName.setText(gname)
        txtGenre.setText(genre)
        txtQuantity.setText("Only "+gquant.toString() + " left in stock!")
        btnPrice.setText(gprice.toString() + "CAD")
        btnPrice.setOnClickListener {
            val intent = Intent(it.context, CheckoutActivity::class.java)
            it.context.startActivity(intent)
        }
        val storRef: StorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(imgUri.toString())
        Glide.with(imgCover.context).load(storRef).into(imgCover)

    }
}