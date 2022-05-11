package com.newsdoubletwobyte.newsapp.core

import com.newsdoubletwobyte.newsapp.data.cache.NewsCache

interface CacheDataSource : Save<List<NewsCache>>, Fetch<List<NewsCache>>,
    FetchById<Int, NewsCache>