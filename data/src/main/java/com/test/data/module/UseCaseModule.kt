package com.test.data.module

import com.test.domain.repository.ItemRepository
import com.test.domain.usecase.GetItemListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideItemUseCase(repository: ItemRepository) : GetItemListUseCase {
        return GetItemListUseCase(repository)
    }
}