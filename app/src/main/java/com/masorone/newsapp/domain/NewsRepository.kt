package com.masorone.newsapp.domain

import com.masorone.newsapp.core.Fetch
import com.masorone.newsapp.core.FetchById

interface NewsRepository : Fetch<List<NewsDomain>>, FetchById<Int, NewsDomain>