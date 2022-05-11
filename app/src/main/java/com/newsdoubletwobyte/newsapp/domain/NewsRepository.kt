package com.newsdoubletwobyte.newsapp.domain

import com.newsdoubletwobyte.newsapp.core.Fetch
import com.newsdoubletwobyte.newsapp.core.FetchById

interface NewsRepository : Fetch<List<NewsDomain>>, FetchById<Int, NewsDomain>