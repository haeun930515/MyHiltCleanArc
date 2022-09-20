package com.test.data.mapper

import com.test.data.entity.ItemEntity
import com.test.domain.model.Item

object ItemMapper : Mapper<ItemEntity, Item> {
    override fun ItemEntity.mapToDomainModel(): Item {
        return Item(title, description)
    }

    override fun Item.mapFromDomainModel(): ItemEntity {
        return ItemEntity(title, description)
    }

}