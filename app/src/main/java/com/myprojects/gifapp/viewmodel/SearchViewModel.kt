package com.myprojects.gifapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myprojects.gifapp.data.model.GifItem
import com.myprojects.gifapp.states.DataState
import com.myprojects.gifapp.repository.ISearchRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchRepo: ISearchRepository
) : ViewModel() {

    private val _gifList = MutableLiveData<DataState<List<GifItem>>>()
    val gifList: LiveData<DataState<List<GifItem>>> = _gifList

    fun getGifListViaSearch(searchString: String) = viewModelScope.launch(IO) {
        _gifList.postValue(DataState.Loading)
        _gifList.postValue(searchRepo.getGifListViaSearch(searchString))
    }
}