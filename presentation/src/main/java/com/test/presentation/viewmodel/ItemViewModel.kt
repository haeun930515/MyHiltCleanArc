package com.test.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.test.domain.model.Item
import com.test.domain.usecase.GetItemListUseCase
import com.test.domain.usecase.InsertItemUseCase
import com.test.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    getItem: GetItemListUseCase,
    private val insertItem: InsertItemUseCase
) : BaseViewModel(){
    val itemList = getItem()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun onButtonClick(item: Item) = viewModelScope.launch {
        insertItem(item)
    }
}