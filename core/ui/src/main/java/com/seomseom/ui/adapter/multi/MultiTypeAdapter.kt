package com.seomseom.ui.adapter.multi

import android.view.View
import androidx.recyclerview.widget.ListAdapter
import com.seomseom.ui.adapter.viewholder.BaseViewHolder

/**
 * Multi Type RecyclerView 를 위한 공통 Adapter
 */
abstract class MultiTypeAdapter<M : MultiTypeItem>(
    private val onClickListener: (M, View) -> Unit,
    checkContentDiff: (M, M) -> Boolean
) : ListAdapter<M, BaseViewHolder<M>>(MultiTypeDiffUtil(checkContentDiff)) {

    override fun getItemCount(): Int = currentList.size

    override fun getItemViewType(position: Int): Int {
        return currentList[position].viewType.ordinal
    }

    override fun onBindViewHolder(holder: BaseViewHolder<M>, position: Int) {
        val currentItem = currentList[position] as? M ?: return
        holder.onBindView(currentItem)
        holder.onBindListener(currentItem, onClickListener)
    }
}