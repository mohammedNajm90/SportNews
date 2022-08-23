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
            const val NULL_Image =
                "https://www.mexatk.com/wp-content/uploads/2016/11/%D8%B5%D9%88%D8%B1-%D8%B9%D9%86-%D8%A7%D9%84%D8%B1%D9%8A%D8%A7%D8%B6%D8%A9-3.jpg"
        }
    }


}