package com.newsdoubletwobyte.newsapp.domain.repository

import com.newsdoubletwobyte.newsapp.core.Fetch
import com.newsdoubletwobyte.newsapp.domain.model.NewsDomain

interface NewsRepository : Fetch<List<NewsDomain>>