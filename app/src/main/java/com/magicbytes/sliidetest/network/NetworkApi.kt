package com.magicbytes.sliidetest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkApi {
    private var service: NewsService? = null

    @Synchronized
    fun getApi(): NewsService {

        if (service == null) {
            service = Retrofit.Builder()
                .baseUrl("https://contentapi.celltick.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsService::class.java)
        }

        return service!!
    }
}