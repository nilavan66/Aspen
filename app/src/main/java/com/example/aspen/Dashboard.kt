package com.example.aspen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aspen.Popular.Popular
import com.example.aspen.Popular.PopularAdapter
import com.example.aspen.Recommended.Recom
import com.example.aspen.Recommended.RecomAdapter

class Dashboard : AppCompatActivity() {

    private lateinit var popularRecycle: RecyclerView

    private lateinit var popularArrayList: ArrayList<Popular>

    private lateinit var popularAdapter: PopularAdapter


    private lateinit var recomRecycle: RecyclerView

    private lateinit var recomArrayList: ArrayList<Recom>

    private lateinit var recomAdapter: RecomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        popularRecycle = findViewById(R.id.popular)

        recomRecycle = findViewById(R.id.recommended)

        popularRecycle.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        popularArrayList = ArrayList()

        popularArrayList.add(Popular(R.drawable.img1, "Alley Palace", "4.5", "liked"))
        popularArrayList.add(Popular(R.drawable.img2, "Coeurdes Alpes", "3.5", ""))
        popularArrayList.add(Popular(R.drawable.img3, "Colorando", "4.0", "liked"))

        popularAdapter = PopularAdapter(popularArrayList) { item ->
            onPopularItemClick(item)
        }
        popularRecycle.adapter = popularAdapter


        //===================


        recomRecycle.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recomArrayList = ArrayList()
        recomArrayList.add(Recom(R.drawable.img11, "Explore Aspen", "4N/5D"))
        recomArrayList.add(Recom(R.drawable.img22, "Luxurious Aspen", "2N/3D"))

        recomAdapter = RecomAdapter(recomArrayList)
        recomRecycle.adapter = recomAdapter

    }

    private fun onPopularItemClick(popularItem: Popular) {

        val intent = when (popularItem.title) {

            "Coeurdes Alpes" -> Intent(this, MainActivity::class.java)

            "Alley Palace" -> Intent(this, MainActivity::class.java)

            "Colorando" -> Intent(this, MainActivity::class.java)

            else -> null
        }

        intent?.let {
            startActivity(it)
            super.finish()
        }

    }

}