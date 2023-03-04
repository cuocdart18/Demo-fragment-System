package com.example.myapplicationnnn.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplicationnnn.R
import kotlin.random.Random

class TextColorViewModel : ViewModel() {
    private val TAG = TextColorViewModel::class.java.simpleName
    private val colors = listOf(
        "#D50000",
        "#D500F9",
        "#212121",
        "#EEFF41",
        "#304FFE",
        "#304FFE",
        "#FF9100"
    )
    var currentColor = colors[0]
    var savedColor = currentColor

    fun changeTextColor() {
        savedColor = currentColor
        val id = Random.nextInt(0, colors.size)
        currentColor = colors[id]
        Log.d(TAG, "random change id = $id")
        Log.d(TAG, "random change color = $currentColor")
    }

    fun resetCurrentColor() {
        currentColor = savedColor
        Log.d(TAG, "reset current color = $currentColor")
    }
}