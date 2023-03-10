package com.example.interviewexercise.views.util

import android.view.View
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

fun ImageView.load(url: String?){
    Picasso.get()
        .load(url)
        .into(this)
}

fun View.showSnackbar(msg: String, duration: Int = Snackbar.LENGTH_LONG){
    Snackbar.make(this,msg,duration).show()
}