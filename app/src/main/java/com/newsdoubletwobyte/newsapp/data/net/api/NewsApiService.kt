package com.newsdoubletwobyte.newsapp.data.net.api

import com.newsdoubletwobyte.newsapp.data.net.api.model.DataDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET(VALUE_ENDPOINT)
    suspend fun fetch(
        @Query(QUERY_PAGE) page: String = DEFAULT_PAGE,
        @Query(QUERY_KEYWORDS) keyword: String = KEYWORDS,
        @Query(QUERY_SORT_BY_POPULARITY) sortBy: String = SORT_BY_POPULARITY,
        @Query(QUERY_LANGUAGE) language: String = LANGUAGE,
        @Query(QUERY_API_KEY) apiKey: String = API_KEY
    ): DataDto

    private companion object {

        const val VALUE_ENDPOINT = "/v2/everything"

        const val QUERY_KEYWORDS = "q"
        const val QUERY_SORT_BY_POPULARITY = "sortBy"
        const val QUERY_LANGUAGE = "language"
        const val QUERY_PAGE = "page"
        const val QUERY_API_KEY = "apiKey"

        const val KEYWORDS = "Животные"
        const val SORT_BY_POPULARITY = "popularity"
        const val LANGUAGE = "ru"
        const val DEFAULT_PAGE = "1"
        const val API_KEY = "3dea6f508eb14b8fbf7e7452f660fdd3"
    }
}