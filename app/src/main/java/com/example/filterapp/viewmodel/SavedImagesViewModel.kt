package com.example.filterapp.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filterapp.repositories.SavedImageRepository
import com.example.filterapp.utilities.Coroutines
import java.io.File

class SavedImagesViewModel(private val savedImageRepository: SavedImageRepository) : ViewModel() {

    private val savedImagesDataState = MutableLiveData<SaveImagesDataState>()
    val saveImagesUIState: LiveData<SaveImagesDataState> get() = savedImagesDataState

    fun loadSavedImages(){
        Coroutines.io {
            runCatching {
                emitSavedImagesUiState(isLoading = true)
                savedImageRepository.loadSavedImages()
            }.onSuccess { savedImages ->
                if(savedImages.isNullOrEmpty()){
                    emitSavedImagesUiState(error = "No Image Found")
                }else{
                    emitSavedImagesUiState(savedImages = savedImages)
                }
            }.onFailure {
                emitSavedImagesUiState(error = it.message.toString())
            }
        }
    }

    private fun emitSavedImagesUiState(
        isLoading: Boolean = false,
        savedImages: List<Pair<File, Bitmap>>? = null,
        error: String? = null
    ){
        val dataState = SaveImagesDataState(isLoading, savedImages, error)
        savedImagesDataState.postValue(dataState)
    }

    data class SaveImagesDataState(
        val isLoading: Boolean,
        val savedImages: List<Pair<File, Bitmap>>?,
        val error: String?
    )
}