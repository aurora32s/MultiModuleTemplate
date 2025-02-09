package com.seomseom.ui.adapter.single

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.seomseom.ui.adapter.viewholder.BaseViewHolder

/**
 * 하나의 type 만 가지고 있는 Recyclerview의 adapter
 */
abstract class SingleTypeAdapter<M : SingleTypeItem>(
    private val onClickListener: (M, View) -> Unit,
    checkContentDiff: (M, M) -> Boolean
) : ListAdapter<M, BaseViewHolder<M>>(SingleTypeDiffUtil(checkContentDiff)) {
    override fun onBindViewHolder(holder: BaseViewHolder<M>, position: Int) {
        val currentItem = currentList[position] as? M ?: return
        holder.onBindView(currentItem)
        holder.onBindListener(currentItem, onClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<M> {
        return onCreateViewHolder(parent)
    }

    abstract fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<M>
}