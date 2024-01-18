package com.example.aspen.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aspen.R
import com.example.aspen.Recommended.Recom
import javax.inject.Inject

class RecomViewModel @Inject constructor() : ViewModel() {

    private val _recomList = MutableLiveData<List<Recom>>()
    val recomList: LiveData<List<Recom>> get() = _recomList

    fun fetchData() {
        _recomList.value = listOf(
            Recom(R.drawable.img11, "Explore Aspen", "4N/5D"),
            Recom(R.drawable.img22, "Luxurious Aspen", "2N/3D")
        )
    }
}