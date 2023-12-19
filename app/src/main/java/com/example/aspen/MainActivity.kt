package com.example.aspen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aspen.Icon.Icon
import com.example.aspen.Icon.IconAdapter
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var iconRecycle: RecyclerView

    private lateinit var iconArrayList: ArrayList<Icon>
    private lateinit var iconAdapter: IconAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iconRecycle = findViewById(R.id.f_items)

        iconRecycle.layoutManager = GridLayoutManager(this, 4)
        iconArrayList = ArrayList()
        iconArrayList.add(Icon(R.drawable.wifi, "Wifi"))
        iconArrayList.add(Icon(R.drawable.food, "Dinner"))
        iconArrayList.add(Icon(R.drawable.bath_tub, "Tub"))
        iconArrayList.add(Icon(R.drawable.pool, "Pool"))

        iconAdapter = IconAdapter(iconArrayList)
        iconRecycle.adapter = iconAdapter

    }
}