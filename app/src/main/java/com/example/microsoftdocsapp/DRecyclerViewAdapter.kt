package com.example.microsoftdocsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.ImageView
import androidx.core.graphics.drawable.toDrawable

class DRecyclerViewAdapter(private val docModels: ArrayList<DocsModel>) :
    RecyclerView.Adapter<DRecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, i: Int) {
        holder.documentName.text = docModels[i].productName
//        holder.rightArrow.setImageDrawable(R.drawable.baseline_arrow_right_24.toDrawable())
    }

    override fun getItemCount(): Int {
        return docModels.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val documentName: TextView = itemView.findViewById(R.id.mainText)
//        val rightArrow: ImageView = itemView.findViewById(R.id.rightArrow)
    }
}