package hu.hm.ibm_rainbowcake.ui.detail

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.hm.ibm_rainbowcake.data.model.Item
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailPresenter: DetailPresenter
) : RainbowCakeViewModel<DetailViewState>(DetailViewState()) {

    fun load(item: Item) = execute {
        Timber.d("Loading item")
        // Api does not provide GET(itemID: ID) - No need for background tasks
        viewState = DetailViewState(item)
    }

}