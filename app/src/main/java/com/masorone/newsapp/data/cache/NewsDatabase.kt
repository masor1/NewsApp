package com.masorone.newsapp.data.cache

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsCache::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {

        private const val DB_NAME = "news.db"
        private val LOCK = Any()
        private var db: NewsDatabase? = null

        fun getInstance(application: Application): NewsDatabase = synchronized(LOCK) {
            db?.let { db ->
                return db
            }
            val instance = Room.databaseBuilder(
                application,
                NewsDatabase::class.java,
                DB_NAME
            )
                .build()
            db = instance
            return instance
        }
    }
}