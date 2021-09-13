package com.example.diffutils_concatadapter_retrofit.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutils_concatadapter_retrofit.R
import com.example.diffutils_concatadapter_retrofit.adapter.FeedImageAdapter
import com.example.diffutils_concatadapter_retrofit.adapter.HeaderAdapter
import com.example.diffutils_concatadapter_retrofit.databinding.MainFragmentBinding
import com.example.diffutils_concatadapter_retrofit.model.Image
import com.example.diffutils_concatadapter_retrofit.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    lateinit var adapters: ConcatAdapter
    private val adapterFeedImage = FeedImageAdapter()
    private val adapterHeader = HeaderAdapter {
        viewModel.fetchImages(it)
    }

    private val observeImages = Observer<List<Image>> {
        adapterFeedImage.submitList(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.images.observe(viewLifecycleOwner, observeImages)


        adapters =  ConcatAdapter(adapterHeader, adapterFeedImage)
        setupRecyclerView()
    }

    private fun setupRecyclerView() = with(binding.recyclerView) {
        adapter = adapters
        layoutManager = LinearLayoutManager(requireContext())
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                hideSoftInput()
            }
        })
        viewModel.fetchImages()

    }

    fun View.hideSoftInput() {
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }
}