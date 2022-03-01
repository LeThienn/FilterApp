package com.example.filterapp.repositories

import android.graphics.Bitmap
import android.net.Uri

interface EditImageRepository {
    suspend fun prepareImagePreview(imageUri: Uri): Bitmap?
}