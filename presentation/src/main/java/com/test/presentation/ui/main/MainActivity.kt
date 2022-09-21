package com.test.presentation.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.test.presentation.R
import com.test.presentation.base.BaseActivity
import com.test.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_frame_layout) as NavHostFragment
            bottomNavigationView.setupWithNavController(navHostFragment.navController)
            bottomNavigationView.setOnItemReselectedListener {  }
        }
    }
}

class EmptyFragment : Fragment()