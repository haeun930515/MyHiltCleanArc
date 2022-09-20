package com.test.data.repository

import com.test.data.cache.ItemDao
import com.test.data.entity.ItemEntity
import com.test.data.mapper.ItemMapper.mapFromDomainModel
import com.test.data.mapper.ItemMapper.mapToDomainModel
import com.test.data.network.ktor.ItemService
import com.test.domain.model.Item
import com.test.domain.model.status.Result
import com.test.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemRepositoryImpl @Inject constructor(
    private val itemService: ItemService,
    private val itemDao: ItemDao
) : ItemRepository{
    override fun getItems(): Flow<List<Item>>  = flow{
        when (val response = itemService.getItemList()) {
            is Result.Success -> {
                itemDao.insertItem(response.data)
                emit(response.data.map { it.mapToDomainModel() })
            }
            is Result.ApiError, is Result.NetworkError -> {
                emitAll(itemDao.getItemList().map { it.mapToDomainModel() })
            }
            else -> Unit
        }
    }

    override suspend fun insertItem(item: Item) {
        itemDao.insertItem(item.mapFromDomainModel())
    }

    private fun List<ItemEntity>.mapToDomainModel() = map { it.mapToDomainModel()}
}