package com.example.microsoftdocsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class D_RecyclerViewAdapter(private val docModels: ArrayList<DocsModel>) :
    RecyclerView.Adapter<D_RecyclerViewAdapter.MyViewHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row, parent, false)
            return MyViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: MyViewHolder, i: Int) {
            val currentItem = docModels[i]
            holder.documentName.text = currentItem.productName
            holder.rightArrow.setImageDrawable(R.drawable.baseline_arrow_right_24.toDrawable())
        }

        override fun getItemCount(): Int {
            return docModels.size
        }

        class MyViewHolder(itemView: View)
            : RecyclerView.ViewHolder(itemView) {
                val documentName: TextView = itemView.findViewById(R.id.mainText)
                val rightArrow: ImageView = itemView.findViewById(R.id.rightArrow)
        }
}