package com.masorone.newsapp.core

import com.masorone.newsapp.data.net.NewsCloud

interface CloudDataSource : FetchPage<String, List<NewsCloud>>