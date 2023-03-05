package com.example.myapplicationnnn.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnnn.databinding.ItemInstalledAppBinding
import com.example.myapplicationnnn.models.InstalledApp

class InstalledAppAdapter(val callback: (installedApp: InstalledApp) -> Unit) :
    RecyclerView.Adapter<InstalledAppAdapter.AppViewHolder>() {
    private lateinit var binding: ItemInstalledAppBinding
    private lateinit var installedApps: MutableList<InstalledApp>

    @SuppressLint("NotifyDataSetChanged")
    fun setData(installedApps: MutableList<InstalledApp>) {
        this.installedApps = installedApps
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        binding =
            ItemInstalledAppBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return AppViewHolder(binding)
    }

    override fun getItemCount(): Int = installedApps.size

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val installedApp = installedApps[position]
        // update UI
        holder.binding.tvLabelApp.text = installedApp.label
        holder.binding.imgIconApp.setImageDrawable(installedApp.icon)
        holder.binding.root.setOnClickListener {
            callback(installedApp)
        }
    }

    inner class AppViewHolder(val binding: ItemInstalledAppBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {

        }
    }
}