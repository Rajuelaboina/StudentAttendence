package com.raju.multipleview.model

import android.graphics.drawable.Drawable

data class ShortNews(
    override val title: String,
    override val image: Drawable?,
    val date: String ):News()


