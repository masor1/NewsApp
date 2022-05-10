package com.newsdoubletwobyte.newsapp.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(listOfNewsCache: List<NewsCache>)

    @Query("SELECT * FROM news ORDER BY publishedAt DESC")
    fun fetch(): List<NewsCache>

    @Query("SELECT * FROM news WHERE id == :newsId limit 1")
    fun fetchById(newsId: Int): NewsCache
}