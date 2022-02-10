package hu.hm.ibm_rainbowcake.ui.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
        private val listPresenter: ListPresenter
) : RainbowCakeViewModel<ListViewState>(ListViewState()) {

    fun load() = execute {
        Timber.d("Doing fetch of items")
        viewState = viewState.copy(isRefreshing = true)
        viewState = ListViewState(listPresenter.getData(), false)
    }

    fun loadMore() = execute {
        Timber.d("Doing fetch of more items")
        viewState = viewState.copy(isLoadingMore = true)
        val oldItems = viewState.items.toMutableList()
        oldItems.addAll(listPresenter.getData())
        viewState = ListViewState(oldItems, isLoadingMore = false)
    }
}
