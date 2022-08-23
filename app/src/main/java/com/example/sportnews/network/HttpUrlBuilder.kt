package com.example.sportnews.network


import android.util.Log
import com.example.sportnews.util.Constants
import okhttp3.HttpUrl

class HttpUrlBuilder {
    fun buildHttpUrl() = with(Constants.HttpUrl) {
        val keys = Constants.HttpUrl.Keys
        val values = Constants.HttpUrl.Values

        HttpUrl.Builder()
            .scheme(SCHEME)
            .host(HOST)
            .addPathSegments(PATH_SEGMENTS)
            .addQueryParameter(keys.COUNTRY, values.COUNTRY_VALUE)
            .addQueryParameter(keys.CATEGORY, values.CATEGORY_VALUE)
            .addQueryParameter(keys.API_KEY, values.API_KEY_VALUE)
            .build()

    }
}