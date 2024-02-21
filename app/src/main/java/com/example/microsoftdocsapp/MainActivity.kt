package com.example.microsoftdocsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private lateinit var docsModel : ArrayList<DocsModel>;
    private lateinit var recyclerView: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        setUpDocsMadel()

    }

    private fun setUpDocsMadel(): Unit {
        val docsNames: Array<String> = resources.getStringArray(R.array.products)

        for (i in 0..docsNames.size){
            docsModel.add(DocsModel(docsNames[i]))
        }

        recyclerView.adapter = D_RecyclerViewAdapter(docsModel)
    }
}
