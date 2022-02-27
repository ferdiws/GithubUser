package id.ferdinand.githubuser.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ferdinand.githubuser.data.model.DetailUserResponseModel
import id.ferdinand.githubuser.data.repository.DetailUserRepository

class DetailUserViewModel: ViewModel() {
    private var detailUserResponseModel: MutableLiveData<DetailUserResponseModel> = MutableLiveData()

    fun getDetailUser(username: String): LiveData<DetailUserResponseModel> {
        DetailUserRepository.init(username)
        detailUserResponseModel = DetailUserRepository.getDetailUser()
        return detailUserResponseModel
    }
}