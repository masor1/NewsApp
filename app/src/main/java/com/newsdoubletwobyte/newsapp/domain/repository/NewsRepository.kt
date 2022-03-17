package com.newsdoubletwobyte.newsapp.domain.repository

import com.newsdoubletwobyte.newsapp.core.Fetch
import com.newsdoubletwobyte.newsapp.domain.pojo.News

interface NewsRepository : Fetch<List<News>>