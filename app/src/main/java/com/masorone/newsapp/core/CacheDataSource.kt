package com.masorone.newsapp.core

import com.masorone.newsapp.data.cache.NewsCache

interface CacheDataSource : Save<List<NewsCache>>, Fetch<List<NewsCache>>,
    FetchById<Int, NewsCache>