package com.myprojects.gifapp.ui.fragment

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.myprojects.gifapp.R
import com.myprojects.gifapp.data.model.GifItem
import com.myprojects.gifapp.states.DataState
import com.myprojects.gifapp.databinding.FragmentHomeBinding
import com.myprojects.gifapp.ui.adapter.GifListAdapter
import com.myprojects.gifapp.util.AppUtil.hideKeyboard
import com.myprojects.gifapp.util.viewBinding
import com.myprojects.gifapp.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewmodel by viewModel<SearchViewModel>()

    private var gifList = listOf<GifItem>()
    private val gifAdapter = GifListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        setListeners()
        setupRecyclerView()
    }

    private fun setListeners() = binding.apply {
        editGifSearch.setOnEditorActionListener { textView, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if(Build.VERSION.SDK_INT >= 23) {
                    viewmodel.getGifListViaSearch(editGifSearch.text.toString())
                    hideKeyboard(requireActivity())
                }
            }
            false
        }
    }

    private fun subscribeObservers() {
        viewmodel.gifList.observe(viewLifecycleOwner) { state ->
            binding.apply {
                when(state) {
                    is DataState.Success -> {
                        progressSearch.isInvisible = true
                        textMessage.isGone = true
                        gifList = state.data
                        gifAdapter.submitList(state.data)
                    }
                    is DataState.EmptyResult -> {
                        progressSearch.isInvisible = true
                        textMessage.isVisible = true
                        textMessage.text = getString(R.string.no_result_found)
                        gifAdapter.submitList(emptyList())
                    }
                    is DataState.Loading -> {
                        progressSearch.isInvisible = false
                        textMessage.isGone = true
                    }
                    is DataState.Failure -> {
                        progressSearch.isInvisible = true
                        textMessage.isVisible = true
                        textMessage.text = getString(R.string.server_error, state.error)
                        gifAdapter.submitList(emptyList())
                    }
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerSearchResult.apply {
            adapter = gifAdapter
            layoutManager = GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)
        }
    }
}