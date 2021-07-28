package com.myprojects.gifapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.myprojects.gifapp.R
import com.myprojects.gifapp.data.entity.GifData
import com.myprojects.gifapp.data.entity.GifEntityResponse
import com.myprojects.gifapp.data.model.GifItem
import com.myprojects.gifapp.databinding.FragmentHomeBinding
import com.myprojects.gifapp.ui.adapter.GifListAdapter
import com.myprojects.gifapp.util.viewBinding
import com.myprojects.gifapp.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewmodel by viewModel<SearchViewModel>()

    private var gifList = listOf<GifData>()
    private val gifAdapter = GifListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        setListeners()
        setupRecyclerView()
    }

    private fun setListeners() = binding.apply {
        buttonSearch.setOnClickListener {
            viewmodel.getGifListViaSearch(editGifSearch.text.toString())
        }
    }

    private fun subscribeObservers() {
        viewmodel.gifList.observe(viewLifecycleOwner) {
            gifList = it
            gifAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerSearchResult.apply {
            adapter = gifAdapter
            layoutManager = GridLayoutManager(requireContext(), 4, GridLayoutManager.VERTICAL, false)
        }
    }
}