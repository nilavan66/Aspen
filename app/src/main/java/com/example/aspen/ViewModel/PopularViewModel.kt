package com.example.aspen.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aspen.Popular.Popular
import com.example.aspen.R
import javax.inject.Inject

class PopularViewModel @Inject constructor() : ViewModel() {
    private val _popularList = MutableLiveData<List<Popular>>()
    val popularList: LiveData<List<Popular>> get() = _popularList

    fun fetchData() {
        _popularList.value = listOf(
            Popular(R.drawable.img1, "Alley Palace", "4.5", "liked"),
            Popular(R.drawable.img2, "Coeurdes Alpes", "3.5", ""),
            Popular(R.drawable.img3, "Colorando", "4.0", "liked")
        )
    }
}