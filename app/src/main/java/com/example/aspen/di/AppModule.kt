package com.example.aspen.di

import com.example.aspen.ViewModel.PopularViewModel
import com.example.aspen.ViewModel.RecomViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { PopularViewModel() }
    viewModel { RecomViewModel() }
}