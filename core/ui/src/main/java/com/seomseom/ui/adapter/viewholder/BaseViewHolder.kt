package com.seomseom.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding

/**
 * RecyclerView 공통 ViewHolder
 */
abstract class BaseViewHolder<E>(
    binding: ViewBinding
) : ViewHolder(binding.root) {
    // 중복 클릭 방지를 위한 클릭 시간
    private var lastClickedTime: Long = 0L

    abstract fun onBindView(item: E)
    open fun onBindListener(item: E, onClickListener: (E, View) -> Unit) {}
}