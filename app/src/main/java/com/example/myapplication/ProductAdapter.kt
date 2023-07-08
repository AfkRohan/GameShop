package com.example.myapplication

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class ProductAdapter(options: FirebaseRecyclerOptions<Product>):
    FirebaseRecyclerAdapter<Product, ProductAdapter.MyViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater, parent)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int,model: Product) {
        Log.i("Debug"," " + model.Cover + " " + model.Genre + " " + model.Price + " " + model.Quantity + " " + model.Title)

        val storeRef: StorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.Cover)
        Glide.with(holder.imgPhoto.context).load(storeRef).into(holder.imgPhoto)

        holder.txtTitle.text = model.Title
        holder.txtPrice.text = model.Price

        holder.btnViewMore.setOnClickListener {
            val intent = Intent(it.context, com.example.myapplication.Details::class.java)
            it.context.startActivity(intent)
        }


    }


    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.activity_row_layout, parent, false))
    {
        val txtTitle : TextView = itemView.findViewById(R.id.txtTitle)
        val txtPrice : TextView = itemView.findViewById(R.id.txtPrice)
        val btnViewMore: Button = itemView.findViewById(R.id.btnViewMore)
        val imgPhoto: ImageView = itemView.findViewById(R.id.imgPhoto)
    }

}