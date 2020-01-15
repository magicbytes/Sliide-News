package com.magicbytes.sliidetest.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.magicbytes.sliidetest.network.NetworkApi
import com.magicbytes.sliidetest.network.NewsRequestResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsRepositoryImpl : NewsRepository {

    override fun getAllNews(): LiveData<List<News>> {
        val data = MutableLiveData<List<News>>()

        NetworkApi.getApi().getNews().enqueue(object : Callback<NewsRequestResponse> {
            override fun onFailure(call: Call<NewsRequestResponse>, t: Throwable) {
                data.postValue(emptyList())
            }

            override fun onResponse(
                call: Call<NewsRequestResponse>,
                response: Response<NewsRequestResponse>
            ) {
                val responseBody = response.body()
                data.postValue(responseBody?.content ?: emptyList())
            }
        })

        return data
    }
}