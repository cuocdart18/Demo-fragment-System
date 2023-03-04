package com.example.myapplicationnnn.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationnnn.databinding.FragmentFirstMenuBinding
import com.example.myapplicationnnn.viewmodels.FirstMenuViewModel

class FirstMenuFragment : Fragment() {
    private val TAG = FirstMenuFragment::class.java.simpleName
    private lateinit var binding: FragmentFirstMenuBinding
    private val viewModel: FirstMenuViewModel by lazy {
        ViewModelProvider(requireActivity())[FirstMenuViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView")
        binding = FragmentFirstMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
        binding.tvName.text = viewModel.name
        binding.tvType.text = viewModel.type
        binding.tvOs.text = viewModel.os
    }
}