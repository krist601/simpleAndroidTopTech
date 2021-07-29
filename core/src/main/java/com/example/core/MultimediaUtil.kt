package com.example.core

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun getImgPicasso(endpoint: String?, view: ImageView?, error: Int) {
    if (endpoint != null && endpoint.isNotEmpty()) Picasso.get().load(endpoint).error(error).into(view)
    else Picasso.get().load(error).error(error).into(view)
}