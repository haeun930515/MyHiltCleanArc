package com.test.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.test.data.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM items")
    fun getItemList(): Flow<List<ItemEntity>>

    @Insert
    suspend fun insertItem(vararg item: ItemEntity)

    @Insert
    suspend fun insertItem(items: List<ItemEntity>)
}