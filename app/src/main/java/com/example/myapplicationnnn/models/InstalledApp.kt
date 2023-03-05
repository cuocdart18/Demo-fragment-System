package com.example.myapplicationnnn.models

import android.content.Intent
import android.graphics.drawable.Drawable

data class InstalledApp(
    val icon: Drawable,
    val label: String,
    val launchIntent: Intent?
)
