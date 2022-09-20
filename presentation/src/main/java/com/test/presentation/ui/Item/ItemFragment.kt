package com.test.presentation.ui.Item

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.test.domain.model.Item
import com.test.presentation.R
import com.test.presentation.adapter.ItemAdapter
import com.test.presentation.base.BaseFragment
import com.test.presentation.databinding.FragmentItemBinding
import com.test.presentation.viewmodel.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ItemFragment : BaseFragment<FragmentItemBinding, ItemViewModel>(R.layout.fragment_item){
    override val viewModel: ItemViewModel by viewModels()

    private lateinit var itemAdapter: ItemAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemAdapter = ItemAdapter()

        binding.rvItem.adapter = itemAdapter

        var cnt = 0
        binding.insertButton.setOnClickListener {
            viewModel.onButtonClick(Item("Title${cnt++}","Description${cnt++}"))
        }

        lifecycleScope.launch {
            viewModel.itemList.flowWithLifecycle(lifecycle).collect{
                itemAdapter.submitList(it)
            }
        }
    }

}