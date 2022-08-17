package com.example.sportnews.util

object Constants {
    object HttpUrl {
        const val SCHEME = "https"
        const val HOST = "newsapi.org"
        const val PATH_SEGMENTS = "v2/top-headlines"

        object Keys {
            const val COUNTRY = "country"
            const val CATEGORY = "category"
            const val API_KEY = "apiKey"
        }

        object Values {
            const val COUNTRY_VALUE = "eg"
            const val CATEGORY_VALUE = "sports"
            const val API_KEY_VALUE = "f0c5c69210d54df5b29f235edfc6cc93"
        }
    }


}