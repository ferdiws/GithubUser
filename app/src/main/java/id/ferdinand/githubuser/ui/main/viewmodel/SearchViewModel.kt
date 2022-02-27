package id.ferdinand.githubuser.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ferdinand.githubuser.data.model.SearchResponseModel
import id.ferdinand.githubuser.data.repository.SearchRepository

class SearchViewModel: ViewModel() {
    private var searchResponseModel: MutableLiveData<SearchResponseModel> = MutableLiveData()

    fun getSearchData(username: String): LiveData<SearchResponseModel> {
        SearchRepository.init(username)
        searchResponseModel =SearchRepository.getSearchData()
        return searchResponseModel
    }
}