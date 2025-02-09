package com.seomseom.ui.adapter.multi

import androidx.recyclerview.widget.DiffUtil

open class MultiTypeItem(
    val id: String?, // 각 item을 구분할 수 있는 id
    val viewType: Enum<*>
)

class MultiTypeDiffUtil<M : MultiTypeItem>(
    private val checkContentDiff: (M, M) -> Boolean
) : DiffUtil.ItemCallback<M>() {
    override fun areItemsTheSame(
        oldItem: M,
        newItem: M
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: M,
        newItem: M
    ): Boolean {
        return checkContentDiff(oldItem, newItem)
    }
}