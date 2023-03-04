package com.example.myapplicationnnn.viewmodels

import android.os.Build
import android.util.Log
import androidx.lifecycle.ViewModel

class FirstMenuViewModel : ViewModel() {
    private val TAG = FirstMenuViewModel::class.java.simpleName
    lateinit var name: String
    lateinit var type: String
    lateinit var os: String

    init {
        getInfor()
    }

    private fun getInfor() {
        name = Build.MODEL
        type = Build.DEVICE
        os = Build.VERSION.SDK_INT.toString()
        Log.d(TAG, "get infor name=$name - type=$type - os=$os")
    }
}