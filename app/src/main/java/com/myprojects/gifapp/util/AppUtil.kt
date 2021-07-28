package com.myprojects.gifapp.util

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.signature.ObjectKey
import com.myprojects.gifapp.R

object AppUtil {
    fun hideKeyboard(activity: Activity) {
        val view = activity.currentFocus
        val inManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    fun ImageView.loadImage(imageUrl: String) {
        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.drawable.ic_image_placeholder)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .signature(ObjectKey(System.currentTimeMillis()))
            .into(this)
    }
}