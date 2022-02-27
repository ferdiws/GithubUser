package id.ferdinand.githubuser.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import id.ferdinand.githubuser.BuildConfig
import id.ferdinand.githubuser.data.api.RetrofitApi
import id.ferdinand.githubuser.data.api.RetrofitClient
import id.ferdinand.githubuser.data.model.SearchResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRepository {
    companion object {
        var dataSet: MutableLiveData<SearchResponseModel> = MutableLiveData()

        fun init(username: String){
            val api: RetrofitApi = RetrofitClient.retrofit.create(RetrofitApi::class.java)
            val call: Call<SearchResponseModel> = api.getSearchData(username, BuildConfig.API_KEY)
            call.enqueue(object : Callback<SearchResponseModel> {
                override fun onResponse(call: Call<SearchResponseModel>, response: Response<SearchResponseModel>) {
                    if (response.isSuccessful){
                        dataSet.value = response.body()
                    } else {
                        dataSet.value = null
                    }
                }

                override fun onFailure(call: Call<SearchResponseModel>, t: Throwable) {
                    dataSet.value = null
                    Log.e("DATA", t.message.toString())
                }
            })
        }

        fun getSearchData(): MutableLiveData<SearchResponseModel> {
            return dataSet
        }
    }
}