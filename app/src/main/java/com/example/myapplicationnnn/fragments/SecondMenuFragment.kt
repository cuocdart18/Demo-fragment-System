package com.example.myapplicationnnn.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationnnn.adapter.InstalledAppAdapter
import com.example.myapplicationnnn.databinding.FragmentSecondMenuBinding
import com.example.myapplicationnnn.models.InstalledApp
import com.example.myapplicationnnn.viewmodels.SecondMenuViewModel

class SecondMenuFragment : Fragment() {
    private val TAG = SecondMenuFragment::class.java.simpleName
    private lateinit var binding: FragmentSecondMenuBinding
    private val viewModel: SecondMenuViewModel by lazy {
        ViewModelProvider(requireActivity())[SecondMenuViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView")
        binding = FragmentSecondMenuBinding.inflate(inflater, container, false)
        binding.rcvListInstalledApp.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
        viewModel.getListInstalledApp(requireContext()) {
            val adapter = InstalledAppAdapter {
                onClickInstalledAppItem(it)
            }
            adapter.setData(it)
            binding.rcvListInstalledApp.adapter = adapter
        }
    }

    private fun onClickInstalledAppItem(installedApp: InstalledApp) {
        Log.d(TAG, "on click app ${installedApp.label}")
        installedApp.launchIntent?.let {
            requireActivity().startActivity(it)
        }
    }
}