package com.example.myapplicationnnn.viewmodels

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplicationnnn.models.InstalledApp

class SecondMenuViewModel : ViewModel() {
    private val TAG = SecondMenuViewModel::class.java.simpleName
    private val installedApps = mutableListOf<InstalledApp>()

    @SuppressLint("QueryPermissionsNeeded")
    fun getListInstalledApp(
        context: Context,
        callback: (installedApps: MutableList<InstalledApp>) -> Unit
    ) {
        if (installedApps.isNotEmpty()) {
            callback(installedApps)
            return
        }

        Log.d(TAG, "get list installed app")
        // action
        val pm = context.packageManager;
        val packages = pm.getInstalledApplications(PackageManager.GET_META_DATA)

        packages.forEach {
            val icon = pm.getApplicationIcon(it)
            val launchIntent = pm.getLaunchIntentForPackage(it.packageName)
            val label = pm.getApplicationLabel(it).toString()
            Log.i(TAG, "label = $label")
            Log.i(TAG, "--------------------------------------------------------------------")
            installedApps.add(InstalledApp(icon, label, launchIntent))
        }

        callback(installedApps)
    }
}