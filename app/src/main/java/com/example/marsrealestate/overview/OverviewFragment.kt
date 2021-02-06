package com.example.marsrealestate.overview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.marsrealestate.R
import com.example.marsrealestate.databinding.GridViewItemBinding
import com.example.marsrealestate.databinding.OverviewFragmentBinding

class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = GridViewItemBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}