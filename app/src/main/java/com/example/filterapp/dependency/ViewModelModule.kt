package com.example.filterapp.dependency

import com.example.filterapp.viewmodel.EditImageViewModel
import com.example.filterapp.viewmodel.SavedImagesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { EditImageViewModel(editImageRepository = get()) }
    viewModel { SavedImagesViewModel(savedImageRepository = get()) }
}