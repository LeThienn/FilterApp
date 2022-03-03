package com.example.filterapp.listeners

import com.example.filterapp.data.ImageFilter

interface ImageFilterListener {
    fun onFilterSelected(imageFilter: ImageFilter)
}