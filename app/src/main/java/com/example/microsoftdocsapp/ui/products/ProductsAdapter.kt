package com.example.microsoftdocsapp.ui.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.microsoftdocsapp.R

class ProductsAdapter(private var products: ArrayList<ProductsViewModel>) :
    RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, i: Int) {
        holder.documentName.text = products[i].productName
        holder.rightArrow.setImageResource(R.drawable.baseline_arrow_right_24)

        holder.cardView.setOnClickListener{
//            mainActivity.changeFragment(WebViewerFragment())
//            Toast.makeText(mainActivity, docModels[i].productName, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val documentName: TextView = itemView.findViewById(R.id.mainText)
        val rightArrow: ImageView = itemView.findViewById(R.id.rightArrow)
        val cardView: CardView = itemView.findViewById(R.id.documentCard)
        init {
            itemView.setOnClickListener{_: View ->
                val position: Int = adapterPosition
                products[adapterPosition].url
            }
      }
    }
}