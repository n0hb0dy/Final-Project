package com.example.microsoftdocsapp.ui.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import com.example.microsoftdocsapp.MainActivity
import com.example.microsoftdocsapp.R
import com.example.microsoftdocsapp.databinding.ActivityMainBinding
import com.example.microsoftdocsapp.databinding.FragmentProductsBinding
import com.example.microsoftdocsapp.ui.documentation.DocumentationFragment

class ProductsAdapter(private var products: ArrayList<ProductsViewModel>) :
    RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

    private var _binding: MainActivity? = MainActivity()
    private val binding get() = _binding!!

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
            replaceFragment(DocumentationFragment())
//            mainActivity.changeFragment(WebViewerFragment())
//            Toast.makeText(mainActivity, docModels[i].productName, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager: FragmentManager = binding.supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.productsRV, fragment)
        fragmentTransition.commit()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val documentName: TextView = itemView.findViewById(R.id.mainText)
        val rightArrow: ImageView = itemView.findViewById(R.id.rightArrow)
        val cardView: CardView = itemView.findViewById(R.id.documentCard)
        init {
            itemView.setOnClickListener{_: View ->
                val position: Int = adapterPosition
                    //products[adapterPosition].url
                //replaceFragment(DocumentationFragment())
            }
      }
    }
}