package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class RecyclerView : AppCompatActivity() {
    private var adapter: ProductAdapter?= null;
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)



        val query= FirebaseDatabase.getInstance().reference.child("Gameshop")
        val options= FirebaseRecyclerOptions.Builder<Product>().setQuery(query, Product::class.java).build()
        Log.i("Debug1", options.toString());

        adapter= ProductAdapter(options)
        val rView : RecyclerView = findViewById(R.id.rView)
        Log.i("myTag", rView.toString());
        rView.layoutManager= LinearLayoutManager(this)
        rView.adapter= adapter
    }

    override fun onStart(){
        super.onStart()
        adapter?.startListening()
    }
}