package com.example.aspen.UI

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aspen.MainActivity
import com.example.aspen.Popular.Popular
import com.example.aspen.Popular.PopularAdapter
import com.example.aspen.R
import com.example.aspen.Recommended.Recom
import com.example.aspen.Recommended.RecomAdapter
import com.example.aspen.ViewModel.PopularViewModel
import com.example.aspen.ViewModel.RecomViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.ext.android.viewModel


@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private val popularViewModel: PopularViewModel by viewModel()
    private val recomViewModel: RecomViewModel by viewModel()

    private lateinit var popularRecycle: RecyclerView
    //private lateinit var popularArrayList: ArrayList<Popular>
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


        /*
        popularArrayList = ArrayList()

        popularArrayList.add(Popular(R.drawable.img1, "Alley Palace", "4.5", "liked"))
        popularArrayList.add(Popular(R.drawable.img2, "Coeurdes Alpes", "3.5", ""))
        popularArrayList.add(Popular(R.drawable.img3, "Colorando", "4.0", "liked"))

        */

        val popularListObserver = Observer<List<Popular>> { popularList ->
            popularAdapter.setData(popularList)
        }

        popularViewModel.popularList.observe(viewLifecycleOwner, popularListObserver)

        /*
        popularAdapter = PopularAdapter(popularArrayList) { item ->
            onPopularItemClick(item)
        }
*/

        popularAdapter = PopularAdapter(emptyList()) { item ->
            onPopularItemClick(item)
        }

        popularRecycle.adapter = popularAdapter


        popularViewModel.fetchData()


        //===================


        recomRecycle.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


/*
        recomArrayList = ArrayList()
        recomArrayList.add(Recom(R.drawable.img11, "Explore Aspen", "4N/5D"))
        recomArrayList.add(Recom(R.drawable.img22, "Luxurious Aspen", "2N/3D"))

        */

        val recomListObserver = Observer<List<Recom>> { recomList ->
            recomAdapter.setData(recomList)
        }
        recomViewModel.recomList.observe(viewLifecycleOwner, recomListObserver)


       // recomAdapter = RecomAdapter(recomArrayList)


        recomAdapter = RecomAdapter(emptyList())

        recomRecycle.adapter = recomAdapter

        recomViewModel.fetchData()


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