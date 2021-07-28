package com.myprojects.gifapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.myprojects.gifapp.data.model.GifItem
import com.myprojects.gifapp.databinding.ItemSearchedGifBinding
import com.myprojects.gifapp.util.AppUtil.loadImage

class GifListAdapter : ListAdapter<GifItem, GifListAdapter.GifViewHolder>(GifDiffUtil()) {

    inner class GifViewHolder(val binding: ItemSearchedGifBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val view = ItemSearchedGifBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GifViewHolder(view)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        val item = currentList[position]
        holder.binding.imageGif.loadImage(item.previewImageUrl)
    }

}


class GifDiffUtil : DiffUtil.ItemCallback<GifItem>() {
    override fun areItemsTheSame(oldItem: GifItem, newItem: GifItem) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: GifItem, newItem: GifItem) = oldItem == newItem
}