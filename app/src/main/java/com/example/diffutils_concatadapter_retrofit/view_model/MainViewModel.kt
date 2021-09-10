package com.example.diffutils_concatadapter_retrofit.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diffutils_concatadapter_retrofit.model.Image
import com.example.diffutils_concatadapter_retrofit.repository.PixabayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository : PixabayRepository) : ViewModel() {


    private val _images = MutableLiveData<List<Image>>()
    val images : LiveData<List<Image>> = _images

    fun fetchImages(q: String = "") {
        viewModelScope.launch {
            val returnedImages = repository.fetchImages(q = q)
            returnedImages?.let {
                _images.value = it
            }
        }
    }
}