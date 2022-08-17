package com.example.sportnews.news

import com.example.sportnews.Data.NewsData
import com.example.sportnews.network.Client
import com.example.sportnews.network.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NewsRepository {
    private val client = Client()
    fun getNewsInfo(): Flow<State<NewsData>> = flow {
        emit(State.Loading)
        emit(client.requestNewsData())
    }.flowOn(Dispatchers.IO)
}