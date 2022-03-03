package com.example.filterapp.adapters

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filterapp.databinding.ItemContainerSavedImageBinding
import com.example.filterapp.listeners.SavedImageListener
import java.io.File

class SavedImagesAdapter(
    private val saveImages: List<Pair<File, Bitmap>>,
    private val savedImageListener: SavedImageListener
) :
    RecyclerView.Adapter<SavedImagesAdapter.SavedImageViewHolder>() {

    inner class SavedImageViewHolder(val binding: ItemContainerSavedImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedImageViewHolder {
        val binding = ItemContainerSavedImageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return SavedImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedImageViewHolder, position: Int) {
        with(holder) {
            with(saveImages[position]) {
                binding.imageSaved.setImageBitmap(second)
                binding.imageSaved.setOnClickListener{
                    savedImageListener.onImageClicked(first)
                }
            }
        }
    }

    override fun getItemCount() = saveImages.size
}