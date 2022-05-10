package com.newsdoubletwobyte.newsapp.domain

import com.newsdoubletwobyte.newsapp.core.Fetch

interface NewsRepository : Fetch<List<NewsDomain>>