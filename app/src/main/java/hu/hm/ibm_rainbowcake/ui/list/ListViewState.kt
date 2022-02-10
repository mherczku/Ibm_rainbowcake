package hu.hm.ibm_rainbowcake.ui.list

import hu.hm.ibm_rainbowcake.data.model.Item

data class ListViewState(
        val items: List<Item> = emptyList(),
        val isRefreshing: Boolean = false,
        val isLoadingMore: Boolean = false
)
