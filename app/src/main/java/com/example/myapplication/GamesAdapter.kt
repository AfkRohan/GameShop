package com.example.myapplication


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class GamesAdapter(options: FirebaseRecyclerOptions<Games>) : FirebaseRecyclerAdapter<Games, GamesAdapter.MyViewHolder>(options)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater  = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater, parent)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: Games) {
        val storRef: StorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.Cover.toString())
        Glide.with(holder.imgPhoto.context).load(storRef).into(holder.imgPhoto)
        holder.txtPrice.text = model.Price.toString()
        holder.txtName.text = model.Title.toString()
        holder.btnClick.setOnClickListener {
            val intent = Intent(it.context, DetailsActivity::class.java)
            intent.putExtra("Name", model.Title)
            intent.putExtra("Price", model.Price)
            intent.putExtra("Quantity", model.Quantity)
            intent.putExtra("ImageUrl",model.Cover)
            intent.putExtra("Genre",model.Genre)
            it.context.startActivity(intent)
        }
    }

    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(inflater.inflate(R.layout.card1, parent, false))
    {
        val txtName : TextView = itemView.findViewById(R.id.txtTitle)
        val txtPrice : TextView = itemView.findViewById(R.id.txtPrice)
        val imgPhoto : ImageView = itemView.findViewById(R.id.imgGame)
        val btnClick : Button = itemView.findViewById(R.id.btnViewMore)
    }
}