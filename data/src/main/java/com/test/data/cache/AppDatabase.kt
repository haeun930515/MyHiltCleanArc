package com.test.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.data.entity.ItemEntity

@Database(
    entities = [ItemEntity::class],
    version = 1
)

abstract class AppDatabase : RoomDatabase(){
    abstract fun itemDao(): ItemDao

    companion object {
        private const val databaseName = "item-db"

        fun buildDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, databaseName)
                .fallbackToDestructiveMigration()
                .build()
    }
}