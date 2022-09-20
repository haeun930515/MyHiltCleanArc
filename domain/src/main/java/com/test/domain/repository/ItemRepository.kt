package com.test.domain.repository

import com.test.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getItems(): Flow<List<Item>>
    suspend fun insertItem(item: Item)
}