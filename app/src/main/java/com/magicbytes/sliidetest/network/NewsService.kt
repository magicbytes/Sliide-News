package com.magicbytes.sliidetest.network

import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @GET("mediaApi/v1.0/content?key=t4QCg6zCkFrCW5CTJii52IAQojqNmyeJ&publisherId=Magazine_from_AppDevWebsite&userId=eccc7785-001c-4341-88f8-eddf15f3aa4a&countryCode=US&language=en&limit=100&offset=0")
    fun getNews(): Call<NewsRequestResponse>
}