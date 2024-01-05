package com.example.aspen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aspen.Popular.Popular
import com.example.aspen.Popular.PopularAdapter
import com.example.aspen.Recommended.Recom
import com.example.aspen.Recommended.RecomAdapter


class DashboardFragment : Fragment() {

    private lateinit var popularRecycle: RecyclerView

    private lateinit var popularArrayList: ArrayList<Popular>

    private lateinit var popularAdapter: PopularAdapter


    private lateinit var recomRecycle: RecyclerView

    private lateinit var recomArrayList: ArrayList<Recom>

    private lateinit var recomAdapter: RecomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        popularRecycle = view.findViewById(R.id.popular)

        recomRecycle = view.findViewById(R.id.recommended)

        popularRecycle.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

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
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recomArrayList = ArrayList()
        recomArrayList.add(Recom(R.drawable.img11, "Explore Aspen", "4N/5D"))
        recomArrayList.add(Recom(R.drawable.img22, "Luxurious Aspen", "2N/3D"))

        recomAdapter = RecomAdapter(recomArrayList)
        recomRecycle.adapter = recomAdapter


        return view
    }

    private fun onPopularItemClick(popularItem: Popular) {

        val intent = when (popularItem.title) {

            "Coeurdes Alpes" -> Intent(requireContext(), MainActivity::class.java)

            "Alley Palace" -> Intent(requireContext(), MainActivity::class.java)

            "Colorando" -> Intent(requireContext(), MainActivity::class.java)

            else -> null
        }

        intent?.let {
            startActivity(it)
            requireActivity().finish()
        }


    }
}