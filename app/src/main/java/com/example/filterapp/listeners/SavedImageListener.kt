package com.example.filterapp.listeners

import java.io.File

interface SavedImageListener {
    fun onImageClicked(file: File)
}