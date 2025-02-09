package com.seomseom.ui.adapter.single

import androidx.recyclerview.widget.DiffUtil

/**
 * 하나의 type만 사용 하는 recyclerview의 아이템
 */
open class SingleTypeItem(
    val id: String?
)

class SingleTypeDiffUtil<M : SingleTypeItem>(
    private val checkContentDiff: (M, M) -> Boolean
) : DiffUtil.ItemCallback<M>() {
    override fun areItemsTheSame(oldItem: M, newItem: M): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: M, newItem: M): Boolean {
        return checkContentDiff(oldItem, newItem)
    }
}