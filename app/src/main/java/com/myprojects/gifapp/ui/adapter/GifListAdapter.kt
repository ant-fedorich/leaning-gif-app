package com.myprojects.gifapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.signature.ObjectKey
import com.bumptech.glide.request.RequestOptions
import com.myprojects.gifapp.R
import com.myprojects.gifapp.data.entity.GifData
import com.myprojects.gifapp.databinding.ItemSearchedGifBinding

class GifListAdapter : ListAdapter<GifData, GifListAdapter.GifViewHolder>(GifDiffUtil()) {

    inner class GifViewHolder(val binding: ItemSearchedGifBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val view = ItemSearchedGifBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GifViewHolder(view)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        val item = currentList[position]
        holder.binding.imageGif.loadImage(item.images.fixedWidthSmallStill.url)
    }

}


class GifDiffUtil : DiffUtil.ItemCallback<GifData>() {
    override fun areItemsTheSame(oldItem: GifData, newItem: GifData) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: GifData, newItem: GifData) = oldItem == newItem
}


fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this)
        .load(imageUrl)
        .placeholder(R.drawable.ic_channel_facebook)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .signature(ObjectKey(System.currentTimeMillis()))
        .into(this)
}