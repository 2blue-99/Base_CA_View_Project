package com.example.base_view_project.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.base_view_project.R
import com.example.base_view_project.databinding.ActivityMainBinding
import com.example.base_view_project.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {
    override val viewModel: MainViewModel by viewModels()

    override fun setData() {

    }

    override fun setObserver() {

    }

    override fun setListener() {

    }
}