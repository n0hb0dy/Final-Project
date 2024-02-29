package com.example.microsoftdocsapp.ui.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.microsoftdocsapp.MainActivity
import com.example.microsoftdocsapp.R
import java.net.URL

class ProductsAdapter(private var productNames: Array<String>, private val urls: Array<String>) :
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
        holder.documentName.text = productNames[i]
        holder.rightArrow.setImageResource(R.drawable.baseline_arrow_right_24)

//        holder.cardView.setOnClickListener{
//            mainActivity.changeFragment(WebViewerFragment())
//            Toast.makeText(mainActivity, docModels[i].productName, Toast.LENGTH_LONG).show()
//        }
    }

    override fun getItemCount(): Int {
        return productNames.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val documentName: TextView = itemView.findViewById(R.id.mainText)
        val rightArrow: ImageView = itemView.findViewById(R.id.rightArrow)
        init {
            itemView.setOnClickListener{v: View ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "You clicked on iten #${position + 1}", Toast.LENGTH_SHORT).show()

            }
        }
    }
}