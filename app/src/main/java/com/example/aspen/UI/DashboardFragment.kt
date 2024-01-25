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
import com.example.aspen.Popular.Popular
import com.example.aspen.Popular.PopularAdapter
import com.example.aspen.R
import com.example.aspen.Recommended.Recom
import com.example.aspen.Recommended.RecomAdapter
import com.example.aspen.ViewModel.PopularViewModel
import com.example.aspen.ViewModel.RecomViewModel
import com.example.aspen.databinding.FragmentDashboardBinding

import org.koin.androidx.viewmodel.ext.android.viewModel


class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    private val popularViewModel: PopularViewModel by viewModel()
    private val recomViewModel: RecomViewModel by viewModel()

    private lateinit var popularAdapter: PopularAdapter
    private lateinit var recomAdapter: RecomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val view = binding.root

        setupRecyclerView(binding.popular)
        setupRecyclerView(binding.recommended)

        setupPopularRecyclerView()
        setupRecomRecyclerView()

        return view
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
    private fun setupPopularRecyclerView() {
        popularAdapter = PopularAdapter(emptyList()) { item ->
            onPopularItemClick(item)
        }

        binding.popular.adapter = popularAdapter


        val popularListObserver = Observer<List<Popular>> { popularList ->
            popularAdapter.setData(popularList)
        }

        popularViewModel.popularList.observe(viewLifecycleOwner, popularListObserver)

        popularViewModel.fetchData()

    }
    private fun setupRecomRecyclerView() {
        recomAdapter = RecomAdapter(emptyList())

        binding.recommended.adapter = recomAdapter

        val recomListObserver = Observer<List<Recom>> { recomList ->
            recomAdapter.setData(recomList)
        }

        recomViewModel.recomList.observe(viewLifecycleOwner, recomListObserver)

        recomViewModel.fetchData()

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