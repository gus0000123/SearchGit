package com.jonghyun.searchgit

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding>(
    @LayoutRes
    private val layoutId: Int
) : AppCompatActivity() {
    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)

        binding.lifecycleOwner = this
        setListener()
        observeUi()
    }

    //IOC(Inversion Of Control)개념을 도입해서 onCreate 에서 자동 호출되게 만들었습니다.
    abstract fun setListener()
    abstract fun observeUi()
}