package id.ferdinand.githubuser.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import id.ferdinand.githubuser.BuildConfig
import id.ferdinand.githubuser.data.api.RetrofitApi
import id.ferdinand.githubuser.data.api.RetrofitClient
import id.ferdinand.githubuser.data.model.DetailUserResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserRepository {
    companion object {
        var dataSet: MutableLiveData<DetailUserResponseModel> = MutableLiveData()

        fun init(username: String){
            val api: RetrofitApi = RetrofitClient.retrofit.create(RetrofitApi::class.java)
            val call: Call<DetailUserResponseModel> = api.getDetailUser(username, BuildConfig.API_KEY)
            call.enqueue(object : Callback<DetailUserResponseModel> {
                override fun onResponse(call: Call<DetailUserResponseModel>, response: Response<DetailUserResponseModel>) {
                    if (response.isSuccessful){
                        dataSet.value = response.body()
                    } else {
                        dataSet.value = null
                    }
                }

                override fun onFailure(call: Call<DetailUserResponseModel>, t: Throwable) {
                    dataSet.value = null
                    Log.e("DATA", t.message.toString())
                }
            })
        }

        fun getDetailUser(): MutableLiveData<DetailUserResponseModel> {
            return dataSet
        }
    }
}