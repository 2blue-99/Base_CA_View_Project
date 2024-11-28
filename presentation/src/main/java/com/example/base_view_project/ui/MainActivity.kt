package com.example.base_view_project.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.base_view_project.R
import com.example.base_view_project.databinding.ActivityMainBinding
import com.example.base_view_project.ui.base.BaseActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {
    override val viewModel: MainViewModel by viewModels()

    override fun setData() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        binding.navBottom.setupWithNavController(navHostFragment.navController)
    }

    override fun setObserver() {

    }

    override fun setListener() {

    }

    /**
     * 하단 메뉴 프래그먼트 연결
     */
//    private fun setBottomNavigator() {
//
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
//        binding.navBottom.setupWithNavController(navHostFragment.navController)
//
//        BottomSheetBehavior.from(binding.bottomSheetPrepaid).also {
//            it.state = BottomSheetBehavior.STATE_HIDDEN
//            it.addBottomSheetCallback(getBottomSheetCallback())
//        }
//
//        BottomSheetBehavior.from(binding.bottomSheetStore).also {
//            it.state = BottomSheetBehavior.STATE_HIDDEN
//            it.addBottomSheetCallback(getBottomSheetCallback())
//        }
//
//        BottomSheetBehavior.from(binding.bottomSheetSelectCoupon).also {
//            it.state = BottomSheetBehavior.STATE_HIDDEN
//            it.addBottomSheetCallback(getBottomSheetCallback())
//        }
//
//    }
}