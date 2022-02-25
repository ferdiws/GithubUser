package id.ferdinand.githubuser.data.api

import id.ferdinand.githubuser.BuildConfig
import id.ferdinand.githubuser.data.model.DetailUserResponseModel
import id.ferdinand.githubuser.data.model.ItemUserResponseModel
import id.ferdinand.githubuser.data.model.SearchResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitApi {
    @GET(BuildConfig.SEARCH)
    fun getSearchData(@Query("q") username: String, @Header("Authorization") token: String) : Call<SearchResponseModel>

    @GET(BuildConfig.DETAIL_USER)
    fun getDetailUser(@Path("username") username: String, @Header("Authorization") token: String): Call<DetailUserResponseModel>

    @GET(BuildConfig.LIST_FOLLOWER)
    fun getFollowers(@Path("username") username: String, @Header("Authorization") token: String): Call<List<ItemUserResponseModel>>

    @GET(BuildConfig.LIST_FOLLOWING)
    fun getFollowings(@Path("username") username: String, @Header("Authorization") token: String): Call<List<ItemUserResponseModel>>
}