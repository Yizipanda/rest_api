package com.yizicorp.anonymous

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo
import com.squareup.picasso.Picasso

class ProductAdapter(private val mlist: List<Products>):RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.product_card,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
     return mlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val products = mlist[position]

        holder.textView.setText(products.title)
        Picasso.get().load(products.images.get(0)).into(holder.imageView)
    }





        class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {

        val imageView: ImageView = ItemView.findViewById(R.id.imageview)
        val textView: TextView = ItemView.findViewById(R.id.textview)

    }


}