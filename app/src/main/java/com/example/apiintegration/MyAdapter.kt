package com.example.apiintegration

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val productArraylist: List<Product>) :

  RecyclerView.Adapter<MyAdapter.MyViewHolder> ()               {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
       val itemView=LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
      return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentitem=productArraylist[position]
      holder.title.text=currentitem.title
      //Image View how to show image view if the image is in form of url , 3rd party Library
      // Picasso
      Picasso.get().load(currentitem.thumbnail).into(holder.image)
    }

    override fun getItemCount(): Int {
     return productArraylist.size

    }



  class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    var title:TextView
    var image:ShapeableImageView
    init {
      title=itemView.findViewById(R.id.ProductTitle)
      image=itemView.findViewById(R.id.productImage)
    }

  }


}