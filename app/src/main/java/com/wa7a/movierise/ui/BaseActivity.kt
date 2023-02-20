package com.wa7a.movierise.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.wa7a.mvvmapp.data.viewmodel.MainViewModel

abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {
    private val LOG_TAG: String = "BaseActivity"
    protected lateinit var binding: VB
    abstract val layoutId: Int
    protected val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId);

        setup()
    }

    abstract fun setup()

    protected fun log(value: String) {
        Log.v(LOG_TAG, value)
    }
}