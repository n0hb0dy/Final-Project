package com.example.microsoftdocsapp.ui.products

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.microsoftdocsapp.R

class ProductCardsAdaptor(private val productCards: ArrayList<ProductCardsModel>) :
    RecyclerView.Adapter<ProductCardsAdaptor.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.product_cards, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, i: Int) {
        holder.documentName.text = productCards[i].productName
        holder.rightArrow.setImageResource(R.drawable.baseline_arrow_right_24)
    }

    override fun getItemCount(): Int {
        return productCards.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val documentName: TextView = itemView.findViewById(R.id.mainText)
        val rightArrow: ImageView = itemView.findViewById(R.id.rightArrow)
    }
}