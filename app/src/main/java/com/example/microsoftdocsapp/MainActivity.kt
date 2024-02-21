package com.example.microsoftdocsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.microsoftdocsapp.DocsModel
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private var docsModel : ArrayList<DocsModel> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

    }

    private fun setUpDocsMadel(): Unit {
        val docsNames: Array<String> = resources.getStringArray(R.array.products)

        for (i in 1..docsNames.size){
            docsModel.add(DocsModel(docsNames[i]))
        }
    }
}
