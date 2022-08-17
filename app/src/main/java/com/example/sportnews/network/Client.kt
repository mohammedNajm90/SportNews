package com.example.sportnews.network

import android.util.Log
import com.example.sportnews.Data.NewsData
import com.google.gson.Gson
import okhttp3.HttpUrl

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class Client {
    private val httpUrlBuilder = HttpUrlBuilder()
    private val httpUrl = httpUrlBuilder.buildHttpUrl()
    private val okHttpClient = OkHttpClient()
    private val gson = Gson()

    fun requestNewsData(): State<NewsData> {
        val request = buildRequest()
        val response = makeRequest(request)
        return checkResponseState(response)
    }

    private fun buildRequest() = Request.Builder().url(httpUrl).build()

    private fun makeRequest(request: Request) = okHttpClient.newCall(request).execute()

    private fun checkResponseState(response: Response) = if (response.isSuccessful) {
        val news_data = gson.fromJson(response.body!!.string(), NewsData::class.java)
        State.Success(news_data)
    } else {
        State.Fail(response.message)
    }
}