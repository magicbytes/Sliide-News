package com.magicbytes.sliidetest.feature

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.magicbytes.sliidetest.data.News
import com.magicbytes.sliidetest.data.NewsRepository
import com.magicbytes.sliidetest.data.NewsRepositoryImpl

class NewsListViewModel(
    private val repository: NewsRepository = NewsRepositoryImpl()
) : ViewModel() {

    private val allNews = MediatorLiveData<List<News>>()

    init {
        refreshNews()
    }

    fun getAllNews() = allNews

    fun refreshNews() {
        allNews.addSource(repository.getAllNews()) { listNews ->
            allNews.postValue(listNews)
        }
    }
}