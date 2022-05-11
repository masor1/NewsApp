package com.newsdoubletwobyte.newsapp.core

import com.newsdoubletwobyte.newsapp.data.net.NewsCloud

interface CloudDataSource : FetchPage<String, List<NewsCloud>>