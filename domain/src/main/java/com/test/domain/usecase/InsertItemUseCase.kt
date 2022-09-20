package com.test.domain.usecase

import com.test.domain.model.Item
import com.test.domain.repository.ItemRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InsertItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository
){
    suspend operator fun invoke(item: Item) = itemRepository.insertItem(item)
}