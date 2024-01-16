package com.gwestank.adaptermenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gwestank.adaptermenu.adapter.ViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var isStatus: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mDATA = arrayOf(
            "Pork",
            "Rice",
            "Fish",
            "Water",
            "Mango",
            "Milk",
            "Cat!"
        )

        val adapter = ViewAdapter(this@MainActivity, mDATA!!)
        val horizontalLayoutManager =
            LinearLayoutManager(
                applicationContext!!,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        recyclerView.layoutManager = horizontalLayoutManager
        recyclerView.adapter = adapter


        btnView.setOnClickListener {
            if(isStatus){
                isStatus = false
                val adapter = ViewAdapter(this@MainActivity, mDATA!!)
                val horizontalLayoutManager =
                    LinearLayoutManager(
                        applicationContext!!,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                recyclerView.layoutManager = horizontalLayoutManager
                recyclerView.adapter = adapter
            }
            else{
                isStatus = true
                val adapter = ViewAdapter(this@MainActivity, mDATA!!)
                val horizontalLayoutManager =
                    LinearLayoutManager(
                        applicationContext!!,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                recyclerView.layoutManager = horizontalLayoutManager
                recyclerView.adapter = adapter
            }
        }

    }
}