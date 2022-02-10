package hu.hm.ibm_rainbowcake.ui.list

import androidx.recyclerview.widget.DiffUtil
import hu.hm.ibm_rainbowcake.data.model.Item

object ArticlePreviewComparator : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.guid == newItem.guid
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

}